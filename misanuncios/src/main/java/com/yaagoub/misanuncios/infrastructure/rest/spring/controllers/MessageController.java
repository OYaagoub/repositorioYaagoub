package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.yaagoub.misanuncios.application.service.ConversationService;
import com.yaagoub.misanuncios.application.service.MessageService;
import com.yaagoub.misanuncios.application.service.NotificationService;
import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.domain.Notification;
import com.yaagoub.misanuncios.domain.User;

import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.MessageDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.MessageDtoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@Tag(name = "Message Controller", description = "CRUD operations for Message ")
public class MessageController {

    private  final MessageService messageService;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();

    private final MessageDtoMapper messageDtoMapper;
    private final NotificationService notificationService;
    private  final ConversationService conversationService;


    @MessageMapping("/conversation/{id}")
    @SendTo("/topic/{id}")
    public ResponseEntity<Object> sendMessage(@Payload MessageDto messageDto, @DestinationVariable long id) {


         Message message = messageDtoMapper.toDomain(messageDto, context);
         Conversation getFromData = conversationService.findById(id);
         message.setConversation(getFromData);
         message.setSendAt(new Date());
         message.setRead(false);
         Message response =messageService.save(message);

        Notification noti=new Notification();
        if(getFromData.getSender().getId() == message.getSender().getId()){
            noti.setUser(getFromData.getProduct().getUser());
        }else{
            noti.setUser(getFromData.getSender());
        }
        noti.setSendAt(new Date());
        noti.setMessage(message.getMessage());
        notificationService.save(noti);
         return ResponseEntity.ok().body(messageDtoMapper.toDto(response, context));

        //return ResponseEntity.ok().body("Authentication Required");

        //return ResponseEntity.ok().body("");
    }

    @PostMapping("/api/v3/content/messages/{id}")
    public ResponseEntity<Object> getMessagesByConversation(@PathVariable long id){
        if(getAuthentication() instanceof  User user){
            System.out.println(messageService.getMessagesByConversation(id));
            var response = messageService.getMessagesByConversation(id)
                    .stream().map(
                    message -> messageDtoMapper.toDto(message,context)
            ).toList();
            //System.out.println(response);
            if(!response.isEmpty()){
                //if(response.get(0).getSender().getId()==user.getId() || response.get(0).getConversation().getProduct().getUser().getId()==user.getId()){
                    return ResponseEntity.ok().body(response);
                //}
            }

            return ResponseEntity.ok().body("[]");
        }

        return ResponseEntity.ok().body("Authentication Required");

    }
    private Object getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal();
    }
}

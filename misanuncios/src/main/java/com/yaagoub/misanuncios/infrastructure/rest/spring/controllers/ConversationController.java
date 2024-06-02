package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaagoub.misanuncios.application.service.ConversationService;
import com.yaagoub.misanuncios.application.service.ProductService;
import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ConversationDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("/api/v3/content")
public class ConversationController {
    private final ConversationService conversationService;
    private final ConversationDtoMapper conversationDtoMapper;
    private final ProductService productService;

    private final CycleAvoidingMappingContext context=new CycleAvoidingMappingContext();

    @GetMapping("/conversations/mine")
    public ResponseEntity<Object> getConversationsByUser(){
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> data= new HashMap<>();
        if (this.getAuthentication() instanceof User user){
            var response =conversationService.getConversationsByUser(user.getId()).stream()
                    .map(conversation -> {
                        System.out.println(conversation);
                        return conversationDtoMapper.toDto(conversation,context);
                    }).toList();
            return ResponseEntity.ok().body(response);

        }
        return ResponseEntity.ok().body("Authentication Required");
    }
    @PostMapping("/conversations/save/{idProduct}")
    private ResponseEntity<Object> save(@PathVariable long idProduct){
        if(getAuthentication() instanceof  User user){
            Product product=productService.find(idProduct);
            if(product!=null){
                Conversation con = conversationService.findByUserProduct(product.getId(),user.getId());
                if(con==null && product.getUser().getId()!=user.getId()){
                    con= new Conversation();
                    con.setSender(user);
                    con.setProduct(product);
                    conversationService.save(con);
                }
                return ResponseEntity.ok().body(true);

            }

        }
        return ResponseEntity.ok().body(false);


    }




    private Object getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal();
    }
}
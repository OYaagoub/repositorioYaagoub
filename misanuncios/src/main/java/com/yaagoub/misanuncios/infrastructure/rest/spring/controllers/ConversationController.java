package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaagoub.misanuncios.application.service.ConversationService;
import com.yaagoub.misanuncios.application.service.ProductService;
import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ConversationDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Conversation Controller", description = "CRUD operations for Conversation ")
@RequestMapping("/api/v3/content")
public class ConversationController {
    private final ConversationService conversationService;
    private final ConversationDtoMapper conversationDtoMapper;
    private final ProductService productService;

    private final CycleAvoidingMappingContext context=new CycleAvoidingMappingContext();

    @Operation(summary = "Get all authentication user conversations  ", description = "Retrieve a list of all authentication user conversations.")
    @JsonView({Views.ConversationSample.class})
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
                System.out.println("user.product.id: "+product.getUser().getId() +" user.id"+user.getId());
                if(product.getUser().getId()==user.getId()){
                    return ResponseEntity.ok().body(false);
                }
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

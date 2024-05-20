package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.NotificationService;

import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.NotificationEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.NotificationEntity;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.NotificationDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api/v3/content")
@CrossOrigin("*")
@AllArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;
    private final NotificationDtoMapper notificationDtoMapper;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();


    @GetMapping("notifications")
    public ResponseEntity<Object> getNotifications() throws JsonProcessingException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof User){
            User user = (User) principal;
            var response = notificationService.getNotificationsByUser(user.getId()).stream().map(notification -> {
                        return notificationDtoMapper.toDto(notification,context);
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(response);
        }else{
            return  ResponseEntity.ok().body("Authentication request");
        }



    }

}

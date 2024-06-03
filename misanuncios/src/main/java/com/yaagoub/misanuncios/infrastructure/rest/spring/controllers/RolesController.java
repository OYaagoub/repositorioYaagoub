package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.RoleService;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.RoleDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
@AllArgsConstructor
public class RolesController {
private RoleService roleService;
private RoleDtoMapper roleDtoMapper;
private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
@GetMapping()
public ResponseEntity<Object> getRoles() throws JsonProcessingException {
    var response = roleService.getRoles().stream().map(role -> roleDtoMapper.toDto(role,context))
            .collect(Collectors.toList());
    return ResponseEntity.ok().body(response);
  }



}

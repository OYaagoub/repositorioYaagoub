package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.PermissionService;
import com.yaagoub.misanuncios.application.service.RoleService;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.PermissionDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.RoleDtoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/permissions")
@CrossOrigin("*")
@AllArgsConstructor
@Tag(name = "Permission Controller", description = "CRUD operations for Permission ")
public class PermissionController {
private PermissionService permissionService;
private PermissionDtoMapper permissionDtoMapper;
private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
@GetMapping()
public ResponseEntity<Object> getPermission() throws JsonProcessingException {
    var response = permissionService.getPermissions().stream().map(permission -> permissionDtoMapper.toDto(permission,context))
            .collect(Collectors.toList());
    return ResponseEntity.ok().body(response);
  }

}

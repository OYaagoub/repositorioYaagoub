package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.yaagoub.misanuncios.application.service.UserHasRoleService;
import com.yaagoub.misanuncios.application.service.UserService;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.RoleDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.UserDtoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v3/auth")
@AllArgsConstructor
@RestController
@Tag(name = "User Controller", description = "CRUD operations for User ")
public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;
    private final RoleDtoMapper roleDtoMapper;
    private final UserHasRoleService userHasRoleService;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();


@GetMapping("/user")
public ResponseEntity<?> authenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Object principal = authentication.getPrincipal();

    if (principal instanceof User) {
        User currentUser = (User) principal;
        return ResponseEntity.ok(userDtoMapper.toDto(currentUser, context));
    } else {
        return ResponseEntity.ok().build(); // Return 200 OK with an empty body
    }


}
    @GetMapping("/roles")
    public ResponseEntity<?> authenticatedUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            User currentUser = (User) principal;
            var response = userHasRoleService.getRolesByUser(currentUser).stream()
                    .map(role -> roleDtoMapper.toDto(role,context)).collect(Collectors.toList());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.ok().build(); // Return 200 OK with an empty body
        }
    }

}
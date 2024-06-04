package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.google.gson.Gson;
import com.yaagoub.misanuncios.application.service.RoleService;
import com.yaagoub.misanuncios.application.service.UserHasRoleService;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.domain.UserHasRoleKey;
import com.yaagoub.misanuncios.infrastructure.config.authentication.AuthenticationService;
import com.yaagoub.misanuncios.infrastructure.config.authentication.JwtService;
import com.yaagoub.misanuncios.infrastructure.config.authentication.LoginResponse;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.UserDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/api/v3/auth")
@RestController
@Tag(name = "Authentication Controller", description = "CRUD operations for Authentication ")
public class AuthenticationController {
    private final JwtService jwtService;
    private final UserDtoMapper userDtoMapper;
    private final RoleService roleService;
    private final UserHasRoleService userHasRoleService;
    private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();

    private final AuthenticationService authenticationService;

    public AuthenticationController(UserDtoMapper userDtoMapper, JwtService jwtService, RoleService roleService, UserHasRoleService userHasRoleService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.roleService = roleService;
        this.userHasRoleService = userHasRoleService;
        this.authenticationService = authenticationService;
        this.userDtoMapper=userDtoMapper;
    }

    @Operation(summary = "Sign Up ", description = "Get authentication a new user.")
    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody String registerUserDto) {
        Gson gson = new Gson();

        UserDto regUserDto = gson.fromJson(registerUserDto, UserDto.class);
        User registeredUser = authenticationService.signup(regUserDto);
        UserHasRole userHasRole = new UserHasRole();
        Role role = roleService.findByName("user");
        UserHasRoleKey userHasRoleKey=new UserHasRoleKey();
        userHasRoleKey.setRoleId(role.getId());
        userHasRoleKey.setUserId(registeredUser.getId());
        userHasRole.setId(userHasRoleKey);
        userHasRole.setUser(registeredUser);
        userHasRole.setRole(role);
        userHasRoleService.save(userHasRole);
        return ResponseEntity.ok(userDtoMapper.toDto(registeredUser,context));
    }


    @Operation(summary = "Login", description = "Get authentication a existed user.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody String plainText) {

        Gson gson = new Gson();
        UserDto loginUserDto = gson.fromJson(plainText, UserDto.class);
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}

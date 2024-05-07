package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.config.authentication.AuthenticationService;
import com.yaagoub.misanuncios.infrastructure.config.authentication.JwtService;
import com.yaagoub.misanuncios.infrastructure.config.authentication.LoginResponse;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.UserDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final UserDtoMapper userDtoMapper;
    private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();

    private final AuthenticationService authenticationService;

    public AuthenticationController(UserDtoMapper userDtoMapper,JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.userDtoMapper=userDtoMapper;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDto> register(@RequestBody UserDto registerUserDto) {
        System.out.println("hola");
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(userDtoMapper.toDto(registeredUser,context));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}

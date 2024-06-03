package com.yaagoub.misanuncios.infrastructure.config.authentication;


import com.yaagoub.misanuncios.application.service.UserService;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.controllers.exceptions.AuthenticationFailedException;
import com.yaagoub.misanuncios.infrastructure.rest.spring.controllers.exceptions.UserNotFoundException;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserService userService,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(UserDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userService.save(user);
    }

    public User authenticate(UserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userService.findByEmail(input.getEmail());
    }




//    public User authenticate(UserDto input) {
//        try {
//            // Authenticate the user
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            input.getEmail(),
//                            input.getPassword()
//                    )
//            );
//            // If authentication is successful, retrieve the user
//            String userEmail = authentication.getName();
//            User user = userService.findByEmail(userEmail);
//            // If user does not exist, throw an exception or handle the case appropriately
//            if (user == null) {
//                throw new UserNotFoundException("User not found with email: " + userEmail);
//            }
//            return user;
//        } catch (AuthenticationException e) {
//            // Handle authentication failure
//            throw new AuthenticationFailedException("Authentication failed", e);
//        }
//    }
}
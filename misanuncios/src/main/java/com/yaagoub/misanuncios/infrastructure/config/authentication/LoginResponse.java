package com.yaagoub.misanuncios.infrastructure.config.authentication;

import lombok.*;

@Getter
@Data
@Setter
public class LoginResponse {

    private String token;

    private long expiresIn;

    // Getters and setters...
}
package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserDto {
    private  long id;
    private  String name;

    private String image;

    private String email;

    private Date birth;

    private String password;
    private  String remember_token;
    private  String email_verified_at;

    private  Set<ProductDto> productDtos = new LinkedHashSet<>();

    private Set<NotificationDto> notificationDtos = new LinkedHashSet<>();

    private Set<UserHasRoleDto> roles = new LinkedHashSet<>();

    private Set<UserHasPermissionDto> permissions = new LinkedHashSet<>();

    private Set<ConversationDto> conversationDtos = new LinkedHashSet<>();

}

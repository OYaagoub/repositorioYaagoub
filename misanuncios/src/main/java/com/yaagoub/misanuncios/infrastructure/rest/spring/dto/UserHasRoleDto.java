package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = { "id","role","user"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserHasRoleDto {
    private UserHasRoleKeyDto id;

    private RoleDto role;


    private UserDto user;
}

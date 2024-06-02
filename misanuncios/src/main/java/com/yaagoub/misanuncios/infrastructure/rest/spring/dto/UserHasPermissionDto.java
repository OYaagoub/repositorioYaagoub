package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = { "id","user","permission"})
public class UserHasPermissionDto {
    private UserHasPermissionKeyDto id;

    private UserDto user;

    private PermissionDto permission;
}

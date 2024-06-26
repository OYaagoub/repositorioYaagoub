package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = { "id","role","permission"})
public class RoleHasPermissionDto {

    private RoleHasPermissionKeyDto id;
    private RoleDto role;
    private PermissionDto permission;

}

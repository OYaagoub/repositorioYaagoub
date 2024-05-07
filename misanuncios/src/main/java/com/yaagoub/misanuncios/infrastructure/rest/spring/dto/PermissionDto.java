package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PermissionDto {
    private long id;
    private String name;

    private Set<UserHasPermissionDto> users =new LinkedHashSet<>();

    private Set<RoleHasPermissionDto> roles = new LinkedHashSet<>();
}

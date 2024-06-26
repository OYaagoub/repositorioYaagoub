package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
public class RoleDto {
    @JsonView({Views.RoleComplete.class})
    private long id;
    @JsonView({Views.RoleComplete.class,Views.RoleSample.class})
    private String name;

}

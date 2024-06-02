package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.*;

import java.util.*;

@Data
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
public class UserDto {
    @JsonView({Views.ProductSample.class})
    private  long id;
    private  String name;

    private String image;

    private String email;
    @JsonIgnore
    Set<ProductDto> products = new LinkedHashSet<>();
    private Date birth;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private  String remember_token;
    @JsonIgnore
    private  String email_verified_at;



}

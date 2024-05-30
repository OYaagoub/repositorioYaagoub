package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@ToString(exclude = {"images"})
@EqualsAndHashCode(exclude = { "user","category","images"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductDto {
    private long id;
    private String title;
    private String description;
    private String price;
    private UserDto user;
    private CategoryDto category;
    private Set<ImageDto> images=new LinkedHashSet<>();

}

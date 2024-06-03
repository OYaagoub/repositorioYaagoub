package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@ToString(exclude = {"images"})
@EqualsAndHashCode(exclude = { "user","category","images"})
public class ProductDto {
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private long id;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private String title;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private String description;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private String price;
    @JsonView({Views.ProductSample.class})
    private UserDto user;
    @JsonView({Views.ProductSample.class})
    private CategoryDto category;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private Set<ImageDto> images=new LinkedHashSet<>();
}

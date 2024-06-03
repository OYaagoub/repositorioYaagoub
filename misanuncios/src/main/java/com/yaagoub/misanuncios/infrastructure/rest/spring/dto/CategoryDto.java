package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@ToString(exclude = {"products"})
@NoArgsConstructor
@EqualsAndHashCode(exclude =  {"products"})
public class CategoryDto {
    @JsonView({Views.ProductSample.class,Views.CategorySample.class})
    private long id;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class})
    private String name;
    @JsonView({Views.CategorySample.class})
    Set<ProductDto> products = new LinkedHashSet<>();
}

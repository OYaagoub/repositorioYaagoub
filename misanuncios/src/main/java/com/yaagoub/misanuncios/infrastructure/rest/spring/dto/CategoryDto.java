package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CategoryDto {
    private long id;

    private String name;

    Set<ProductDto> products = new LinkedHashSet<>();
}

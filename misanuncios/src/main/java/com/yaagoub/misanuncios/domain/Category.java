package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude =  {"products"})
public class Category {
    private long id;

    private String name;

    Set<Product> products = new LinkedHashSet<>();
}

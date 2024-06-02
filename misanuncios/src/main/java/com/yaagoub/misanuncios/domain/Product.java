package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ImageDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@ToString(exclude = {"images"})
@EqualsAndHashCode(exclude =  {"user","category","images"})
public class Product {
    private long id;
    private String title;
    private String description;
    private String price;
    private User user;
    private Category category;

    private Set<Image> images=new LinkedHashSet<>();



}

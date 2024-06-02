package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(exclude = {"product"})
@EqualsAndHashCode(exclude = { "product"})
public class ImageDto {
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private long id;
    @JsonView({Views.ProductSample.class,Views.CategorySample.class,Views.ConversationSample.class})
    private String path;

    private ProductDto product;
}

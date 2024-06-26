package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@EqualsAndHashCode(exclude = {"sender", "product"})
public class ConversationDto {
    @JsonView({Views.ConversationSample.class})
    private long id;
    @JsonView({Views.ConversationSample.class})
    private UserDto sender;
    @JsonView({Views.ConversationSample.class})
    private ProductDto product;


}

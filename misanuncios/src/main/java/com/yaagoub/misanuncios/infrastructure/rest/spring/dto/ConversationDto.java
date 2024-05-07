package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@EqualsAndHashCode(exclude = {"sender", "productDto"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ConversationDto {
    private long id;

    private UserDto sender;

    private ProductDto productDto;

    private Set<MessageDto> messageDtos =new LinkedHashSet<>();
}

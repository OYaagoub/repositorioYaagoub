package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@ToString(exclude = {"sender","product"})
@EqualsAndHashCode(exclude =  {"sender","product"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Conversation {
    private long id;

    private User sender;

    private Product product;

    private Set<Message> messages=new LinkedHashSet<>();
}

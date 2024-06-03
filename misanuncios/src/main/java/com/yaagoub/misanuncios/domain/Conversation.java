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
@EqualsAndHashCode(exclude =  {"sender","product"})
public class Conversation {
    private long id;

    private User sender;

    private Product product;


}

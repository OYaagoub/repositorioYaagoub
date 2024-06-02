package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class Role {
    private long id;
    private String name;

}

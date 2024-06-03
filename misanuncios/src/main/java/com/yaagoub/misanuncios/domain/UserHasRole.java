package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude =  {"id","role","user"})
public class UserHasRole  {
    private UserHasRoleKey id;

    private Role role;


    private  User user;
}

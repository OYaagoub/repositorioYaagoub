package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionKeyEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude =  {"id","user","permission"})
public class UserHasPermission {
    private UserHasPermissionKey id;

    private User user;

    private  Permission permission;
}

package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class UserHasPermissionKeyEntity implements Serializable {

    @Column(name = "user_id")
    private long userId;
    @Column(name = "permission_id")
    private long permissionId;
}

package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class RoleHasPermissionKeyEntity implements Serializable {
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "permission_id")
    private long permissionId;
}

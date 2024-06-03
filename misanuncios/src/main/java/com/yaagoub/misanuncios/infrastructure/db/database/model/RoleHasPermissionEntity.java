package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "roleHasPermissions")
public class RoleHasPermissionEntity {

    @EmbeddedId
    private RoleHasPermissionKeyEntity id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;






}

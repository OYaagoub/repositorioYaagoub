package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
@Table(name = "UserHasPermissions")
public class UserHasPermissionEntity {

    @EmbeddedId
    private UserHasPermissionKeyEntity id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @MapsId("permissionId")
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;
}

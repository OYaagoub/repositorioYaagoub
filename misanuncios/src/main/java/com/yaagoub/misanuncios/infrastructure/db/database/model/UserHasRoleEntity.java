package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "userHasRoles")
public class UserHasRoleEntity {
    @EmbeddedId
    private UserHasRoleKeyEntity id;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;
}

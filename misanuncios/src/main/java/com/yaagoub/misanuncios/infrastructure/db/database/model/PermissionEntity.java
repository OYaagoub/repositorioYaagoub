package com.yaagoub.misanuncios.infrastructure.db.database.model;

import com.yaagoub.misanuncios.domain.RoleHasPermission;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

}

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
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;




}

package com.yaagoub.misanuncios.infrastructure.db.database.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    Set<ProductEntity> products = new LinkedHashSet<>();

}

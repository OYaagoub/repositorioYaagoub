package com.yaagoub.misanuncios.infrastructure.db.database.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yaagoub.misanuncios.domain.Image;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@ToString(exclude = {"images","conversations"})
@EqualsAndHashCode(exclude = {"images","conversations"})
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE,mappedBy = "product",orphanRemoval = true)
    private Set<ImageEntity> images = new LinkedHashSet<>();


    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private Set<ConversationEntity> conversations =new LinkedHashSet<>();

}

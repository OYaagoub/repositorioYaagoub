package com.yaagoub.misanuncios.infrastructure.db.database.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yaagoub.misanuncios.domain.Image;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter

@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL,mappedBy = "product",orphanRemoval = true)
    private Set<ImageEntity> images = new LinkedHashSet<>();
    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

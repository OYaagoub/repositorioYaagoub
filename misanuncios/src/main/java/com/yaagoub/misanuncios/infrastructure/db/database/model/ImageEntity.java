package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    //@Column(columnDefinition = "TEXT")
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}

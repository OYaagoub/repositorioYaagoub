package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@RequiredArgsConstructor
@Entity
@ToString(exclude = {"products"})
@EqualsAndHashCode(exclude = {"products"})
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    @Column(unique=true)
    private String image;

    private String email;

    private Date birth;

    private String password;
    private  String remember_token;
    private  String email_verified_at;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    List<ProductEntity> products = new ArrayList<>();


}

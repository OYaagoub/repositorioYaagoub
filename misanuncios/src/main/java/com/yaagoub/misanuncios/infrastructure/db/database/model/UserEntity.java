package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;

    private String image;

    private String email;

    private Date birth;

    private String password;
    private  String remember_token;
    private  String email_verified_at;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH},  orphanRemoval = true)
    private  Set<ProductEntity> products = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH},  orphanRemoval = true)
    private Set<NotificationEntity> notifications = new LinkedHashSet<>();





}

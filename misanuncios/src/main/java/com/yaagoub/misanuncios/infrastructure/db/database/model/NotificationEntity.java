package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "notifications")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sendAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}

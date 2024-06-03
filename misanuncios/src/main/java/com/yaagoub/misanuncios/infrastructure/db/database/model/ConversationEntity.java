package com.yaagoub.misanuncios.infrastructure.db.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
@Data
@RequiredArgsConstructor
@Entity
@ToString(exclude = {"messages"})
@EqualsAndHashCode(exclude = {"messages"})
@Table(name = "conversations")
public class ConversationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @OneToMany(mappedBy = "conversation", fetch = FetchType.EAGER,
            cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private Set<MessageEntity> messages =new LinkedHashSet<>();
}

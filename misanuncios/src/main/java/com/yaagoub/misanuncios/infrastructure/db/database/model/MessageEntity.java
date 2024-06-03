package com.yaagoub.misanuncios.infrastructure.db.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@RequiredArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity sender;
    private String message;
    private Date sendAt;
    private boolean isRead;
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ConversationEntity conversation;

}

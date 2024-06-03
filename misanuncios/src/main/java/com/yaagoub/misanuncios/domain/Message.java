package com.yaagoub.misanuncios.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude =  {"sender","conversation"})

public class Message {

    private long id;
    private User sender;
    private String message;
    private Date sendAt;
    private boolean isRead;
    private Conversation conversation;

}

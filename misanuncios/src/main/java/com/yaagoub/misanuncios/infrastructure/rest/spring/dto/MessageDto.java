package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;
@Data
@EqualsAndHashCode(exclude = {"sender", "conversation"})

public class MessageDto {

    private long id;
    private UserDto sender;
    private String message;
    private Date sendAt;
    private boolean isRead;
    @JsonIgnore
    private ConversationDto conversation;

}

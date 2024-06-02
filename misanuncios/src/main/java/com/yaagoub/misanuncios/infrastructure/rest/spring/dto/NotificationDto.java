package com.yaagoub.misanuncios.infrastructure.rest.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(exclude = { "user"})

public class NotificationDto {
    private long id;
    private String message;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date sendAt;
    private UserDto user;

}

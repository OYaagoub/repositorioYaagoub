package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.MessageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class, ConversationEntityMapper.class})
public interface MessageEntityMapper {

    MessageEntity toEntity(Message source, @Context CycleAvoidingMappingContext context);
    Message toDomain(MessageEntity source, @Context CycleAvoidingMappingContext context);

}

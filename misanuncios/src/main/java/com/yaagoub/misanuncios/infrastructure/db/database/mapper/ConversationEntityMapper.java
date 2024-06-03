package com.yaagoub.misanuncios.infrastructure.db.database.mapper;


import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.MessageEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class, ProductEntityMapper.class})
public interface ConversationEntityMapper {
    ConversationEntity toEntity(Conversation source, @Context CycleAvoidingMappingContext context);
    Conversation toDomain(ConversationEntity source, @Context CycleAvoidingMappingContext context);

}

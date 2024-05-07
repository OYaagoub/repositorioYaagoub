package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Message;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.MessageDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDtoMapper.class, ConversationDtoMapper.class})
public interface MessageDtoMapper {

    MessageDto toDto(Message source, @Context CycleAvoidingMappingContext context);
    Message toDomain(MessageDto source, @Context CycleAvoidingMappingContext context);

}

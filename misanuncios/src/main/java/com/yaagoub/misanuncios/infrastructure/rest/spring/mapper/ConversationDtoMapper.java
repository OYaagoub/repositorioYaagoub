package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;


import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ConversationDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDtoMapper.class, ProductDtoMapper.class})
public interface ConversationDtoMapper {
    ConversationDto toDto(Conversation source, @Context CycleAvoidingMappingContext context);
    Conversation toDomain(ConversationDto source, @Context CycleAvoidingMappingContext context);

}

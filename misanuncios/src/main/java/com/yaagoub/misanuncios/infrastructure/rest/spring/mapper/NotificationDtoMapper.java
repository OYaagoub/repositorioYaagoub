package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Notification;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.NotificationDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDtoMapper.class})
public interface NotificationDtoMapper {
    NotificationDto toDto(Notification source, @Context CycleAvoidingMappingContext context);
    Notification toDomain(NotificationDto source, @Context CycleAvoidingMappingContext context);
}

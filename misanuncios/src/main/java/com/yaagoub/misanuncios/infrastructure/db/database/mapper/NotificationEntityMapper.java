package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.Notification;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.NotificationEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserEntityMapper.class})
public interface NotificationEntityMapper {
    NotificationEntity toEntity(Notification source, @Context CycleAvoidingMappingContext context);
    Notification toDomain(NotificationEntity source, @Context CycleAvoidingMappingContext context);
}

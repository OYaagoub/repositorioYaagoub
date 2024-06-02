package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Conversation;
import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ProductEntityMapper.class})
public interface ImageEntityMapper {

    ImageEntity toEntity(Image source, @Context CycleAvoidingMappingContext context);
    Image toDomain(ImageEntity source, @Context CycleAvoidingMappingContext context);
}

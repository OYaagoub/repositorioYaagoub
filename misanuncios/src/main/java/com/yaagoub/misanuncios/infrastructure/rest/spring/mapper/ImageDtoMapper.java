package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ImageDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductDtoMapper.class})
public interface ImageDtoMapper {
    ImageDto toDto(Image source, @Context CycleAvoidingMappingContext context);
    Image toDomain(ImageDto source, @Context CycleAvoidingMappingContext context);
}

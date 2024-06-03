package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ImageDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ProductDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDtoMapper.class,CategoryDtoMapper.class, ImageDtoMapper.class})
public interface ProductDtoMapper {
    ProductDto toDto(Product source, @Context CycleAvoidingMappingContext context);
    Product toDomain(ProductDto source, @Context CycleAvoidingMappingContext context);

}

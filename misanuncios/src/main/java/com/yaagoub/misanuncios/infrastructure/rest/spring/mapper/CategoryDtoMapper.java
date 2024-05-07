package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;


import com.yaagoub.misanuncios.domain.Category;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.ProductEntityMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.CategoryDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductEntityMapper.class})
public interface CategoryDtoMapper {
    CategoryDto toDto(Category source, @Context CycleAvoidingMappingContext context);
    Category toDomain(CategoryDto source, @Context CycleAvoidingMappingContext context);
}

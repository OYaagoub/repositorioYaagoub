package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Category;
import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.infrastructure.db.database.model.CategoryEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ProductEntityMapper.class})
public interface CategoryEntityMapper {
    CategoryEntity toEntity(Category source, @Context CycleAvoidingMappingContext context);
    Category toDomain(CategoryEntity source, @Context CycleAvoidingMappingContext context);
}

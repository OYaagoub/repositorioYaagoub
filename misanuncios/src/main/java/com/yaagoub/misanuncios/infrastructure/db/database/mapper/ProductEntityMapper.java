package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.db.database.model.CategoryEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ConversationEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ProductEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryEntityMapper.class, ImageEntityMapper.class, ProductEntityMapper.class})
public interface ProductEntityMapper {
    ProductEntity toEntity(Product source, @Context CycleAvoidingMappingContext context);
    Product toDomain(ProductEntity source, @Context CycleAvoidingMappingContext context);

}

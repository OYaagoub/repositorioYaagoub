package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.Permission;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.PermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PermissionEntityMapper.class,UserEntityMapper.class,UserHasPermissionEntityMapper.class, RoleHasPermissionEntityMapper.class})
public interface PermissionEntityMapper {
    PermissionEntity toEntity(Permission source, @Context CycleAvoidingMappingContext context);
    Permission toDomain(PermissionEntity source, @Context CycleAvoidingMappingContext context);
}

package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.RoleHasPermission;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionKeyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleEntityMapper.class,PermissionEntityMapper.class,  RoleHasPermissionKeyEntityMapper.class})
public interface RoleHasPermissionEntityMapper {
    RoleHasPermissionEntity toEntity(RoleHasPermission source, @Context CycleAvoidingMappingContext context);
    RoleHasPermission toDomain(RoleHasPermissionEntity source, @Context CycleAvoidingMappingContext context);
}

package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.RoleHasPermissionKey;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionKeyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.io.Serializable;
@Mapper(componentModel = "spring", uses = {})
public interface RoleHasPermissionKeyEntityMapper {
    RoleHasPermissionKeyEntity toEntity(RoleHasPermissionKey source, @Context CycleAvoidingMappingContext context);
    RoleHasPermissionKey toDomain(RoleHasPermissionKeyEntity source, @Context CycleAvoidingMappingContext context);
}

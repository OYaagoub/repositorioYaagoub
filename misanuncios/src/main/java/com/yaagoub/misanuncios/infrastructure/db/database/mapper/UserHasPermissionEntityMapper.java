package com.yaagoub.misanuncios.infrastructure.db.database.mapper;


import com.yaagoub.misanuncios.domain.UserHasPermission;

import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionKeyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PermissionEntityMapper.class, UserEntityMapper.class, UserHasPermissionKeyEntityMapper.class})
public interface UserHasPermissionEntityMapper {
    UserHasPermissionEntity toEntity(UserHasPermission source, @Context CycleAvoidingMappingContext context);
    UserHasPermission toDomain(UserHasPermissionEntity source, @Context CycleAvoidingMappingContext context);
}

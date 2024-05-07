package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.UserHasPermission;
import com.yaagoub.misanuncios.domain.UserHasPermissionKey;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionKeyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.io.Serializable;
@Mapper(componentModel = "spring", uses = {})
public interface UserHasPermissionKeyEntityMapper  {
    UserHasPermissionKeyEntity toEntity(UserHasPermissionKey source, @Context CycleAvoidingMappingContext context);
    UserHasPermissionKey toDomain(UserHasPermissionKeyEntity source, @Context CycleAvoidingMappingContext context);
}

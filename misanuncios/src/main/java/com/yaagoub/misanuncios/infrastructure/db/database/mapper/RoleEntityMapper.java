package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.db.database.model.ImageEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {RoleHasPermissionEntityMapper.class})
public interface RoleEntityMapper {
    RoleEntity toEntity(Role source, @Context CycleAvoidingMappingContext context);
    Role toDomain(RoleEntity source, @Context CycleAvoidingMappingContext context);
}

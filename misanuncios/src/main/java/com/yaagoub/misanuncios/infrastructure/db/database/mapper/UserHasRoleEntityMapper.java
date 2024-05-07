package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.UserHasPermissionKey;
import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.domain.UserHasRoleKey;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionKeyEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { RoleEntityMapper.class, UserHasRoleKeyEntityMapper.class,UserEntityMapper.class})
public interface UserHasRoleEntityMapper {
    UserHasRoleEntity toEntity(UserHasRole source, @Context CycleAvoidingMappingContext context);
    UserHasRole toDomain(UserHasRoleEntity source, @Context CycleAvoidingMappingContext context);

}

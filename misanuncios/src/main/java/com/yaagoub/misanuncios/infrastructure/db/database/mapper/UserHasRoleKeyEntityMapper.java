package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.domain.UserHasRoleKey;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleKeyEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserHasRoleKeyEntityMapper  {
    UserHasRoleKeyEntity toEntity(UserHasRoleKey source, @Context CycleAvoidingMappingContext context);
    UserHasRoleKey toDomain(UserHasRoleKeyEntity source, @Context CycleAvoidingMappingContext context);
}

package com.yaagoub.misanuncios.infrastructure.db.database.mapper;

import com.yaagoub.misanuncios.domain.RoleHasPermissionKey;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.db.database.model.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity toEntity(User source, @Context CycleAvoidingMappingContext context);
    User toDomain(UserEntity source, @Context CycleAvoidingMappingContext context);
}

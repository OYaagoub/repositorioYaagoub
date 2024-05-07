package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Permission;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.PermissionEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionEntity;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.PermissionDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.RoleHasPermissionDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasPermissionDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PermissionDtoMapper.class,UserDtoMapper.class,UserHasPermissionDtoMapper.class, RoleHasPermissionDtoMapper.class})
public interface PermissionDtoMapper {
    PermissionDto toDto(Permission source, @Context CycleAvoidingMappingContext context);
    Permission toDomain(PermissionDto source, @Context CycleAvoidingMappingContext context);
}

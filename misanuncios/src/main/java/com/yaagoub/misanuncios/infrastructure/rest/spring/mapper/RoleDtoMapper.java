package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.RoleDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.RoleHasPermissionDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasRoleDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserHasRoleDtoMapper.class, RoleHasPermissionDtoMapper.class})
public interface RoleDtoMapper {
    RoleDto toDto(Role source, @Context CycleAvoidingMappingContext context);
    Role toDomain(RoleDto source, @Context CycleAvoidingMappingContext context);
}

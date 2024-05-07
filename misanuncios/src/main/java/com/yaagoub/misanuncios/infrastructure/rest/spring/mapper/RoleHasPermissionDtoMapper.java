package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.RoleHasPermission;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.RoleHasPermissionDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PermissionDtoMapper.class, RoleDtoMapper.class, RoleHasPermissionKeyDtoMapper.class})
public interface RoleHasPermissionDtoMapper {
    RoleHasPermissionDto toDto(RoleHasPermission source, @Context CycleAvoidingMappingContext context);
    RoleHasPermission toDomain(RoleHasPermissionDto source, @Context CycleAvoidingMappingContext context);
}

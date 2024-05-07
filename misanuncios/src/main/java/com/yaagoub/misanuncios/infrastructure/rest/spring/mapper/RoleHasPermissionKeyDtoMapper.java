package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.RoleHasPermissionKey;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.RoleHasPermissionKeyDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface RoleHasPermissionKeyDtoMapper {
    RoleHasPermissionKeyDto toDto(RoleHasPermissionKey source, @Context CycleAvoidingMappingContext context);
    RoleHasPermissionKey toDomain(RoleHasPermissionKeyDto source, @Context CycleAvoidingMappingContext context);
}

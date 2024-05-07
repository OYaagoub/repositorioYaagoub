package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.UserHasPermission;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasPermissionDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PermissionDtoMapper.class, RoleDtoMapper.class, UserHasPermissionKeyDtoMapper.class})
public interface UserHasPermissionDtoMapper {
    UserHasPermissionDto toDto(UserHasPermission source, @Context CycleAvoidingMappingContext context);
    UserHasPermission toDomain(UserHasPermissionDto source, @Context CycleAvoidingMappingContext context);
}

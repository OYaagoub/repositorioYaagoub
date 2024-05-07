package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.UserHasPermissionKey;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasPermissionKeyDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserHasPermissionKeyDtoMapper {
    UserHasPermissionKeyDto toDto(UserHasPermissionKey source, @Context CycleAvoidingMappingContext context);
    UserHasPermissionKey toDomain(UserHasPermissionKeyDto source, @Context CycleAvoidingMappingContext context);
}

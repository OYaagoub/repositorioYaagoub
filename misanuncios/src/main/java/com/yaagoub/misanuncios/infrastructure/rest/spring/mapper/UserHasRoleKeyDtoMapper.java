package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.UserHasRoleKey;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasRoleKeyDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface UserHasRoleKeyDtoMapper {
    UserHasRoleKeyDto toDto(UserHasRoleKey source, @Context CycleAvoidingMappingContext context);
    UserHasRoleKey toDomain(UserHasRoleKeyDto source, @Context CycleAvoidingMappingContext context);
}

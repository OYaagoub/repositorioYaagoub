package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasRoleDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserDtoMapper.class, RoleDtoMapper.class, UserHasRoleKeyDtoMapper.class})
public interface UserHasRoleDtoMapper {
    UserHasRoleDto toDto(UserHasRole source, @Context CycleAvoidingMappingContext context);
    UserHasRole toDomain(UserHasRoleDto source, @Context CycleAvoidingMappingContext context);

}

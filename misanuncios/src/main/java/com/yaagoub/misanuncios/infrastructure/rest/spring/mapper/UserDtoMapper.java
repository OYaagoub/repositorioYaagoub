package com.yaagoub.misanuncios.infrastructure.rest.spring.mapper;

import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.UserHasPermissionKeyDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductDtoMapper.class, RoleDtoMapper.class, UserHasRoleKeyDtoMapper.class, UserHasPermissionKeyDtoMapper.class})
public interface UserDtoMapper {
    UserDto toDto(User source, @Context CycleAvoidingMappingContext context);
    User toDomain(UserDto source, @Context CycleAvoidingMappingContext context);
}

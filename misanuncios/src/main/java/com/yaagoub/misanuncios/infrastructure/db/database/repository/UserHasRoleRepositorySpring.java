package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.UserHasRoleRepository;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;

import com.yaagoub.misanuncios.infrastructure.db.database.mapper.RoleEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserEntityMapper;

import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserHasRoleEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserHasRoleRepositorySpring implements UserHasRoleRepository {
    private  final SpringDataUserHasRoleRepository springDataUserHasRoleRepository;
    private  final RoleEntityMapper roleEntityMapper;
    private final UserEntityMapper userEntityMapper;
    private final UserHasRoleEntityMapper userHasRoleEntityMapper;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();

    @Override
    public Iterable<Role> getRolesByUser(User user) {
        return springDataUserHasRoleRepository.getRolesByUser(userEntityMapper.toEntity(user,context))
                .stream().map(roleEntity -> roleEntityMapper.toDomain(roleEntity,context) ).collect(Collectors.toList());

    }

    @Override
    public UserHasRole save(UserHasRole userHasRole) {
        return userHasRoleEntityMapper.toDomain(springDataUserHasRoleRepository.save(userHasRoleEntityMapper.toEntity(userHasRole,context)),context);
    }
}

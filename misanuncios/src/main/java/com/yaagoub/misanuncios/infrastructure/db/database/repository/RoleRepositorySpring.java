package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.RoleRepository;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.domain.UserHasRole;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.RoleEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserHasRoleEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RoleRepositorySpring implements RoleRepository {
    private final SpringDataRoleRepository springDataRoleRepository;
    private final RoleEntityMapper roleEntityMapper;

    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
    @Override
    public Iterable<Role> getRoles() {
        return springDataRoleRepository.findAll().stream()
                .map(roleEntity ->
                    roleEntityMapper.toDomain(roleEntity,context)
                ).collect(Collectors.toList());
    }

    @Override
    public Role findByName(String name) {
        return roleEntityMapper.toDomain(springDataRoleRepository.findByName(name),context);
    }


}

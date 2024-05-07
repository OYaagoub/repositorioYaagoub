package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.PermissionRepository;
import com.yaagoub.misanuncios.domain.Permission;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.PermissionEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;
@Slf4j
@Repository
@RequiredArgsConstructor
public class PermissionRepositorySpring implements PermissionRepository {
    private final SpringDataPermissionRepository springDataPermissionRepository;
    private final PermissionEntityMapper permissionEntityMapper;

    private CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
    @Override
    public Iterable<Permission> getPermissions() {
        return springDataPermissionRepository.findAll().stream()
                .map(permissionEntity -> permissionEntityMapper.toDomain(permissionEntity,context))
                .collect(Collectors.toList());
    }
}

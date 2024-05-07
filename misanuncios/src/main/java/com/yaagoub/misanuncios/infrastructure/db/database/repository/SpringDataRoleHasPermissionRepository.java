package com.yaagoub.misanuncios.infrastructure.db.database.repository;


import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleHasPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRoleHasPermissionRepository extends JpaRepository<RoleHasPermissionEntity, Long> {
}

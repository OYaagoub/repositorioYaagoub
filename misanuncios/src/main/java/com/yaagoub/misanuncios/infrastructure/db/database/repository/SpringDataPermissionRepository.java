package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPermissionRepository extends JpaRepository<PermissionEntity, Long> {
}

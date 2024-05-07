package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserHasPermissionRepository extends JpaRepository<UserHasPermissionEntity, Long> {
}

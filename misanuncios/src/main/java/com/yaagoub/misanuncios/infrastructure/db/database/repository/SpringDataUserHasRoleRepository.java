package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserHasRoleRepository extends JpaRepository<UserHasRoleEntity, Long> {
}

package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Long> {



}

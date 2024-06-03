package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpringDataRoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query("SELECT  r FROM  RoleEntity r WHERE r.name LIKE %:name%")
    RoleEntity findByName(@Param("name") String name);


}

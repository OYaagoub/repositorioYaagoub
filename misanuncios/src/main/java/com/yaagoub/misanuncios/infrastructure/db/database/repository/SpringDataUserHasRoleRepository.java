package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserHasRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpringDataUserHasRoleRepository extends JpaRepository<UserHasRoleEntity, Long> {

    @Query("SELECT ur.role FROM UserHasRoleEntity ur WHERE ur.user = :user")
    Optional<RoleEntity> getRolesByUser(@Param("user") UserEntity user);

}

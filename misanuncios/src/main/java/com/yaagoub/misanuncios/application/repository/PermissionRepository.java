package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Permission;

public interface PermissionRepository {
    Iterable<Permission> getPermissions();
}

package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Role;

public interface RoleRepository {
    Iterable<Role>  getRoles();
}

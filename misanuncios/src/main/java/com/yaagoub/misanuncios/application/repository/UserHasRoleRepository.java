package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;

public interface UserHasRoleRepository {
    Iterable<Role>  getRolesByUser(User user);
}

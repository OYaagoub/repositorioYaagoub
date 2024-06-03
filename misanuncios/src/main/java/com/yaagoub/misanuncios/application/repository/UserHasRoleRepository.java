package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.domain.UserHasRole;

public interface UserHasRoleRepository {
    Iterable<Role>  getRolesByUser(User user);
    UserHasRole save(UserHasRole userHasRole);
}

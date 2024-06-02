package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;

public interface RoleRepository {
    Iterable<Role>  getRoles();
    Role findByName(String name);


}

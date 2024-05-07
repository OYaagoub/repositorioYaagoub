package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.User;


public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}

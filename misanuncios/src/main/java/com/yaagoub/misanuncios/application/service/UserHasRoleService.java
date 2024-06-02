package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.RoleRepository;
import com.yaagoub.misanuncios.application.repository.UserHasRoleRepository;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.domain.UserHasRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
public class UserHasRoleService {
    private final UserHasRoleRepository repository;
    public List<Role> getRolesByUser(User user){
        return (List<Role>) repository.getRolesByUser(user);
    };
    public UserHasRole save(UserHasRole userHasRole){
        return  repository.save(userHasRole);
    }
}

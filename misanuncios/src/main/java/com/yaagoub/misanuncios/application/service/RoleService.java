package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.RoleRepository;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public List<Role> getRoles(){
        return (List<Role>) repository.getRoles();
    }
    public Role findByName(String name){
        return repository.findByName(name);
    }


}

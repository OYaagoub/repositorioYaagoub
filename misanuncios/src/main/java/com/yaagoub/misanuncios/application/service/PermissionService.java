package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.PermissionRepository;
import com.yaagoub.misanuncios.domain.Permission;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class PermissionService {

    private  final PermissionRepository permissionRepository;

    public List<Permission> getPermissions(){
        return (List<Permission>) permissionRepository.getPermissions();
    }
}

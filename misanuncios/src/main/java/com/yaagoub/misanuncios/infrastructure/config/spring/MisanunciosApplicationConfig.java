package com.yaagoub.misanuncios.infrastructure.config.spring;

import com.yaagoub.misanuncios.application.repository.PermissionRepository;
import com.yaagoub.misanuncios.application.repository.RoleRepository;
import com.yaagoub.misanuncios.application.repository.UserRepository;
import com.yaagoub.misanuncios.application.service.PermissionService;
import com.yaagoub.misanuncios.application.service.RoleService;
import com.yaagoub.misanuncios.application.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MisanunciosApplicationConfig {


     private final RoleRepository roleRepository;
     private final PermissionRepository permissionRepository;
     private final UserRepository userRepository;
     @Bean
     RoleService roleService(){
         return new RoleService(roleRepository);
     }

     @Bean
     PermissionService permissionService(){
         return new PermissionService(permissionRepository);
    }

     @Bean
     UserService userService(){
         return new UserService(userRepository);
     }

}

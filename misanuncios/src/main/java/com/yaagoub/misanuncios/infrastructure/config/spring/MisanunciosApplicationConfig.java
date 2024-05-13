package com.yaagoub.misanuncios.infrastructure.config.spring;

import com.yaagoub.misanuncios.application.repository.*;
import com.yaagoub.misanuncios.application.service.*;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MisanunciosApplicationConfig {


     private final RoleRepository roleRepository;
     private final PermissionRepository permissionRepository;
     private final UserRepository userRepository;
     private final UserHasRoleRepository userHasRoleRepository;
     private final CategoryRepository categoryRepository;
     private final ProductRepository productRepository;
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
    @Bean
    UserHasRoleService userHasRoleService(){
        return new UserHasRoleService(userHasRoleRepository);
    }

    @Bean
    CategoryService categoryService(){
         return new CategoryService(categoryRepository);
    }

    @Bean
    ProductService productService(){
        return new ProductService(productRepository);
    }


}

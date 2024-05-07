package com.yaagoub.misanuncios;

import com.yaagoub.misanuncios.domain.Permission;
import com.yaagoub.misanuncios.domain.Role;
import com.yaagoub.misanuncios.infrastructure.config.spring.MisanunciosApplication;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.PermissionEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.RoleEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.RoleEntity;
import com.yaagoub.misanuncios.infrastructure.db.database.repository.SpringDataPermissionRepository;
import com.yaagoub.misanuncios.infrastructure.db.database.repository.SpringDataRoleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest(classes = MisanunciosApplication.class)
@ContextConfiguration
class MisanunciosApplicationTests {
	@Autowired
	private   SpringDataRoleRepository springDataRoleRepository;
	@Autowired
	private RoleEntityMapper roleEntityMapper;
	@Autowired
	private SpringDataPermissionRepository springDataPermissionRepository;

	@Autowired
	private PermissionEntityMapper permissionEntityMapper;
	private CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();

    /*
    * Work 100%
    * */
	@Test
	void SaveRolesTestRepository() {

		String[] roles = {"admin","user","super-admin"};
		Arrays.asList(roles).forEach(role -> {
			RoleEntity rolled=new RoleEntity();
			rolled.setName(role);
			springDataRoleRepository.save(rolled);
		});



	}
	@Test
	void ShowRolesEntity(){
		List<Role> roles = springDataRoleRepository.findAll().stream()
				.map(roleEntity -> {
					System.out.println(roleEntity.toString());
					return  roleEntityMapper.toDomain(roleEntity,context);
				})
				.collect(Collectors.toList());
		roles.forEach(System.out::println);
	}
	@Test
	void ShowPermissionsEntity(){
		List<Permission> permissions = springDataPermissionRepository.findAll().stream()
				.map(permissionEntity -> {
					System.out.println(permissionEntity.toString());
					return  permissionEntityMapper.toDomain(permissionEntity,context);
				})
				.collect(Collectors.toList());
		permissions.forEach(System.out::println);
	}

}

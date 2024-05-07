package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.UserRepository;
import com.yaagoub.misanuncios.application.service.UserService;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.UserEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.model.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositorySpring implements UserRepository {
    private final SpringDataUserRepository springDataUserRepository;
    private  final UserEntityMapper userEntityMapper;
    private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();

    @Override
    public User findByEmail(String email) {
        return  userEntityMapper.toDomain(springDataUserRepository.findByEmail(email),context);
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userEntityMapper.toEntity(user,context);
        User userIn=userEntityMapper.toDomain(springDataUserRepository.save(userEntity),context);
        return userIn;
    }
}

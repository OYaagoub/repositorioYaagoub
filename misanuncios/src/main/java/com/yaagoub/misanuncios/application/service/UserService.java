package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.UserRepository;
import com.yaagoub.misanuncios.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);

    }
    public User save(User user){
        return userRepository.save(user);

    }


}

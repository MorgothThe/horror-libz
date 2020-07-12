package com.choelinska.horrorlibz.services.impl;

import com.choelinska.horrorlibz.model.dto.UserTo;
import com.choelinska.horrorlibz.model.entities.UserEntity;
import com.choelinska.horrorlibz.repositories.UserRepository;
import com.choelinska.horrorlibz.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    };

    @Override
    public void saveUser(UserTo user) {
        userRepository.save(mapToEntity(user));
    }

    private UserEntity mapToEntity(UserTo user){
        return modelMapper.map(user, UserEntity.class);
    }
}

package com.choelinska.horrorlibz.services.impl;

import com.choelinska.horrorlibz.model.dto.UserTo;
import com.choelinska.horrorlibz.model.entities.UserEntity;
import com.choelinska.horrorlibz.repositories.UserRepository;
import com.choelinska.horrorlibz.services.UserService;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


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
        userRepository.save(this.mapToEntity(user));
    }

    @Override
    public List<UserEntity> getSortedByName(){
        return this.userRepository.findAll(sortByNameDesc());
    }

    @Override
    public List<UserEntity> getUsers(){
        return this.userRepository.findAll();
    }

    private Sort sortByNameDesc() {
        return Sort.by(Sort.Direction.DESC, "username");
    }

    private UserEntity mapToEntity(UserTo user){
        return this.modelMapper.map(user, UserEntity.class);
    }
}
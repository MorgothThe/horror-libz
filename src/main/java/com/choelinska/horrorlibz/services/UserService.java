package com.choelinska.horrorlibz.services;

import com.choelinska.horrorlibz.model.dto.UserTo;
import com.choelinska.horrorlibz.model.entities.UserEntity;


import java.util.List;

public interface UserService {
    public void saveUser(UserTo user);
    List<UserEntity> sortUser();
}
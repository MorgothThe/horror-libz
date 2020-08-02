package com.choelinska.horrorlibz.controllers;

import com.choelinska.horrorlibz.model.dto.UserTo;

import com.choelinska.horrorlibz.model.entities.UserEntity;
import com.choelinska.horrorlibz.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    public UserController(UserService userService){
        this.userService =  userService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserTo user){
        userService.saveUser(user);
    }
}
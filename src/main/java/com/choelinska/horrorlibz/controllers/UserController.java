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

    public UserController(UserService userService, ModelMapper mapper){
        this.userService =  userService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserTo user){
        userService.saveUser(user);
    }

    //Get all users sorted by username DESC
    @GetMapping("/sortedNameDesc")
    public List<UserEntity> getSorted(){
        return userService.getSortedByName();
    }

    //Get all users by ID
    @GetMapping("/all")
    public List<UserEntity> getAll(){
        return userService.getUsers();
    };
}
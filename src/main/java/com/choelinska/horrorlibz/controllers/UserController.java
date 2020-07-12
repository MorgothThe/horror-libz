package com.choelinska.horrorlibz.controllers;

import com.choelinska.horrorlibz.model.dto.UserTo;

import com.choelinska.horrorlibz.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService =  userService;
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserTo user){
        userService.saveUser(user);
    }
}

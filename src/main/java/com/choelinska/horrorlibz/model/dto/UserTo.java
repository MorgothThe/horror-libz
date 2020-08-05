package com.choelinska.horrorlibz.model.dto;

import lombok.Data;

@Data
public class UserTo {
    private long id;
    private String username;
    private String email;
    private String password;
    private String description;
}

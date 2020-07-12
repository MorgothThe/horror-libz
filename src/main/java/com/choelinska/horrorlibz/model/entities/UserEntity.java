package com.choelinska.horrorlibz.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User")
public class UserEntity {
    @Id
    private long id;
    private String username;
    private String email;
    private String password;
    private String description;
}

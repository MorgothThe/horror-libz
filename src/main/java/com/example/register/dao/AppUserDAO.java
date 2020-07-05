package com.example.register.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.register.formbean.AppUserForm;
import com.example.register.model.AppUser;
 
@Repository
public class AppUserDAO {
 
    // Config in WebSecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;
    private static final Map<Long, AppUser> USERS_MAP = new HashMap<>();
 
    static {
        initDATA();
    }
 
    private static void initDATA() {
        String encrytedPassword = "";
        //make user objects
        AppUser lina = new AppUser(1L, "lina","lina@waltdisney.com", encrytedPassword);
        AppUser jerry = new AppUser(2L, "jerry", "jerry@waltdisney.com", encrytedPassword);
        //put userid + user object into map
        USERS_MAP.put(lina.getUserID(), lina);
        USERS_MAP.put(jerry.getUserID(), jerry);
    }
 
    //get max id of users from map
    public Long getMaxUserID() {
        long max = 0;
        for (Long id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
 
    public AppUser findAppUserByUsername(String username) {
    	//make collection out of map values
        Collection<AppUser> appUsers = USERS_MAP.values();
        //for each user in collection
        for (AppUser u : appUsers) {
        	//if username equals username, return user with that username
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
 
    public AppUser findAppUserByEmail(String email) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser u : appUsers) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
 
    public List<AppUser> getAppUsers() {
        List<AppUser> list = new ArrayList<>();
        //add all users to the list
        list.addAll(USERS_MAP.values());
        return list;
    }
 
    public AppUser createAppUser(AppUserForm form) {
        Long userID = this.getMaxUserID() + 1;
        String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
        AppUser user = new AppUser(userID, form.getUsername(),form.getEmail(),encrytedPassword);
        USERS_MAP.put(userID, user);
        return user;
    }
}
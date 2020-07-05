package com.example.register.formbean;

public class AppUserForm {
	 
    private Long userID;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    
    public AppUserForm() {}
 
    public AppUserForm(Long userID, String username, String email,
            String password, String confirmPassword) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
 
    public Long getUserId() {
        return userID;
    }
 
    public void setUserID(Long userID) {
        this.userID = userID;
    }
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getConfirmPassword() {
        return confirmPassword;
    }
 
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
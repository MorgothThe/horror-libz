package com.example.register.model;

public class AppUser {

	private Long userID;
	private String username;
	private String email;
	private String encryptedPassword;
	
	public AppUser() {}
	
	public AppUser(Long userID, String username, String email, String encryptedPassword) {
		super();
		this.userID = userID;
		this.email = email;
		this.username = username;
		this.encryptedPassword = encryptedPassword;
	}
	
	public Long getUserID() {
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
		return encryptedPassword;
	}
	
	public void setPassword() {
		this.encryptedPassword = encryptedPassword;
	}
}

package com.example.java.model;

public class User {
	private int userId;
	private String username;
	private String password;
	private String role;
	private boolean enabled;
	
	

	public User() {
		super();
	}



	public User(int userId, String username, String password, String role, boolean enabled) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

}

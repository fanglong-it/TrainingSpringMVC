package com.example.java.service;

import java.util.List;
import com.example.java.model.User;

public interface UserService {
	
	public User getUserByUsername(String username);
	public List<User> getAllUser();
	public void saveUser(User user);
	public void deleteUser(String username);
	
}

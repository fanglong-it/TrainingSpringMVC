package com.example.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.model.User;
import com.example.java.repository.UserRepository;
import com.example.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		if (userRepository.existsById(username)) {
			return userRepository.findById(username).get();
		}
		return null;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}

}

package com.example.java.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptor {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		String rawPass = "123456";
		String newPass = b.encode(rawPass);
		System.out.println(newPass);
	}
}

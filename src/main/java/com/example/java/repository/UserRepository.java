package com.example.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.model.User;




public interface UserRepository extends JpaRepository<User, String>{

}

package com.example.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.java.model.Authorities;


public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

}

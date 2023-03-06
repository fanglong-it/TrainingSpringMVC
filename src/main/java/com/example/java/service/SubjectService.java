package com.example.java.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.java.model.Subject;

public interface SubjectService {
	
	public Subject getSubjectById(Long id);
	public List<Subject> getAllSubject(Pageable pageable);
	public int countTotalSubject();
	
	public List<Subject> getAllSubjectByName(String name, Pageable pageable);
	
	public List<Subject> findAllSubject();
	
}



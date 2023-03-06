package com.example.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.java.model.Subject;
import com.example.java.repository.SubjectRepository;
import com.example.java.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;

	@Override
	public Subject getSubjectById(Long id) {
		// TODO Auto-generated method stub
		return subjectRepository.findById(id).get();
	}

	@Override
	public List<Subject> getAllSubject(Pageable pageable) {
		// TODO Auto-generated method stub

		return subjectRepository.findAll(pageable).getContent();
	}

	@Override
	public int countTotalSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.getTotalSubject();
	}

	@Override
	public List<Subject> getAllSubjectByName(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return subjectRepository.findByNameContains(name, pageable);
	}

	@Override
	public List<Subject> findAllSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}
	
	

}

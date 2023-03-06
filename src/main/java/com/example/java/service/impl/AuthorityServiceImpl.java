package com.example.java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.java.model.Authorities;
import com.example.java.repository.AuthoritiesRepository;
import com.example.java.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthoritiesRepository repo;

	@Override
	public Authorities getAuthorities(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Authorities> getAllAuthorities() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveAuthority(Authorities authorities) {
		// TODO Auto-generated method stub
		repo.save(authorities);
	}

	@Override
	public void deleteAuthority(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}

package com.example.java.service;

import java.util.List;

import com.example.java.model.Authorities;

public interface AuthorityService {
	public Authorities getAuthorities(long id);
	public List<Authorities> getAllAuthorities();
	public void saveAuthority(Authorities authorities);
	public void deleteAuthority(long id);
}




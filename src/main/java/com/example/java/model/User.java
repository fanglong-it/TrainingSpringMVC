package com.example.java.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {
	
	@Id
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	
	@OneToMany(targetEntity = Authorities.class, fetch = FetchType.LAZY)
	private List<Authorities> authorities = new ArrayList<>();
	

	public User() {
		super();
	}

	

	public User(String username, String password, boolean enabled, List<Authorities> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
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

	

	public List<Authorities> getAuthorities() {
		return authorities;
	}



	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}



	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}

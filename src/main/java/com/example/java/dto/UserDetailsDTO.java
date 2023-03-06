//package com.example.java.dto;
//
//import java.util.Collection;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.example.java.model.Authorities;
//import com.example.java.model.User;
//
//public class UserDetailsDTO implements UserDetails {
//
//	private User user;
//
//	public UserDetailsDTO(User user) {
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
////		return user.getAuthorities().stream()
////				.map(authority -> new SimpleGrantedAuthority(authority.getAuthority().toString()))
////				.collect(Collectors.toList());
//		return null;
//	}
//
//	public User getUserDetails() {
//		return user;
//	}
//
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return user.getUsername();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}

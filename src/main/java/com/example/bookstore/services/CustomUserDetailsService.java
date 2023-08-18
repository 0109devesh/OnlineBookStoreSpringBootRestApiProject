package com.example.bookstore.services;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookstore.entities.User;
import com.example.bookstore.repositories.UserRepository;

import jakarta.transaction.Transactional;



@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//load user from database
		User user = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found!!"));
		
	
		return user;
	}
	
	
	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//		return this.userRepository.findByEmail(email).map(user -> {
//			return new User(user.getEmail(),
//					user.getPassword(),
//					user.getRoles()
//					.stream()
//					.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
//		}).orElseThrow(() -> new UsernameNotFoundException("Email is invalid"));
//	}


}


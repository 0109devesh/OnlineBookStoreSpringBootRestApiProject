package com.example.bookstore.services;

import java.util.Arrays;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.bookstore.entities.User;
import com.example.bookstore.entities.UserDTO;
import com.example.bookstore.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	
	 public UserDTO getUserByEmail(String email) {
	        User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

	        return new UserDTO(user.getUserId(), user.getName(), user.getEmail());
	    }
	
	
	
	

	public User createUser(User createUser) {

		if (this.userRepository.findByEmail(createUser.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is already in use");
		}

		User user = new User();
		user.setName(createUser.getName());
		user.setEmail(createUser.getEmail());

		if (createUser.getRoles() == null) {

			user.setRoles(Arrays.asList("ROLE_USER"));

		}

		else if (createUser.getRoles().isEmpty()) {

			user.setRoles(Arrays.asList("ROLE_USER"));
		}

		else {

			user.setRoles(createUser.getRoles());

		}

		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(createUser.getPassword()));

		return userRepository.save(user);
	}

}

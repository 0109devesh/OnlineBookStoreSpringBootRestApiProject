package com.example.bookstore.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.entities.User;
import com.example.bookstore.entities.UserDTO;
import com.example.bookstore.services.UserService;



@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "*")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	//http://localhost:8081/home/users
	
	@GetMapping("/users")
	public List<User> getUser() {
		
	//	System.out.println("getting users");
		return this.userService.getUsers();
				
	}
	
	
	  @GetMapping("/current-user")
	    public ResponseEntity<String> getLoggedInUser(Principal principal) {
	        String username = principal.getName(); 
	        
	        return ResponseEntity.ok("\"" + username + "\"");
	    }
	
	  
	  
	  @GetMapping("/email/{userEmail}")
	    public UserDTO getUserByEmail(@PathVariable String userEmail) {
	        return userService.getUserByEmail(userEmail);
	    }
	  
	  
	         
	  
	

}

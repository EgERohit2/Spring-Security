package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserServiceImplementation;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImplementation userServiceImplementation;
    @PreAuthorize("hasAuthority('USER')")
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@PostMapping("/user")
	public String postData(@RequestBody User user) {
		
		this.userServiceImplementation.postData(user) ;
		return "posted";
		
	}
	
	
	
}

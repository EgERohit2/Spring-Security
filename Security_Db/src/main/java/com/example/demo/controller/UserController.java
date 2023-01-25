package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.services.UserServiceImplementation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImplementation userServiceImplementation;
	
	@GetMapping()
	public List<User>getAllData(){
		return userServiceImplementation.getAll();
	}
	
	@PostMapping()
	public void postAllData(@RequestBody User user) {
		this.userServiceImplementation.postAll(user);
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home page";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "admin page";
	}
}

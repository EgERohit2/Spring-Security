package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;

@RestController
@RequestMapping("/new")
public class UserController {
	
	@Autowired
	private UsersServices usersServices;
	
	@GetMapping
	public List<Users> getAllData(){
		return usersServices.getAll();
		
	}
}

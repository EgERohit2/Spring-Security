package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersServices;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersServices usersServices;

	@GetMapping()
	public List<Users> getAllData() {
		return usersServices.getAll();
	}

	@GetMapping("/{usersName}")
	public Users getDataByUserName(@PathVariable("usersName") String userName) {
		return this.usersServices.getUserByName(userName);
	}

	@PostMapping()
	public Users postAllData(@RequestBody Users users) {
		return usersServices.addUser(users);
	}

}

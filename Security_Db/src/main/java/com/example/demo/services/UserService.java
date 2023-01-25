package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {

	public List<User> getAll();
	
	public void postAll(User user);
}

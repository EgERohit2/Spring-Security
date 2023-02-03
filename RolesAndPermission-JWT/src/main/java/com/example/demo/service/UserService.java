package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {

	public User postData(User user);
	
	public List<User> getData();
}

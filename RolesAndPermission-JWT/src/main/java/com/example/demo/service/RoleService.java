package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Role;

public interface RoleService {

	public Role postData(Role role);
	
	public List<Role> getData();
}

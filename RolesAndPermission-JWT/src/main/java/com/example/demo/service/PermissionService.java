package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Permission;

public interface PermissionService {

	public Permission postData(Permission permission);
	
	public List<Permission> getData();
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Permission;
import com.example.demo.service.PermissionService;

@RestController
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping()
	public String postAllData(@RequestBody Permission permission) {
		this.permissionService.postData(permission);
		return "posted";
	}

	@GetMapping()
	public List<Permission> getAllData() {
		return this.permissionService.getData();
	}
}

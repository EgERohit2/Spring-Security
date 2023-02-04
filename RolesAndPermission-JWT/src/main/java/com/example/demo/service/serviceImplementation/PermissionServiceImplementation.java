package com.example.demo.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Permission;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;
@Service
public class PermissionServiceImplementation implements PermissionService{

	@Autowired
	private PermissionRepository permissionRepository;
	
	@Override
	public Permission postData(Permission permission) {
		Permission k=new Permission();
		k.setPersmissionname(permission.getPersmissionname());
		return this.permissionRepository.save(k);
	}

	@Override
	public List<Permission> getData() {
		return this.permissionRepository.findAll();
	}

}

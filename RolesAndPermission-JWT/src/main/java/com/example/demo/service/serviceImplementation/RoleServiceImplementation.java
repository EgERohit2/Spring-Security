package com.example.demo.service.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
@Service
public class RoleServiceImplementation implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role postData(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getData() {
		return roleRepository.findAll();
	}

}

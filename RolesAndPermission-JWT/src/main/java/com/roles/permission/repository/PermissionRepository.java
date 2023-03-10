package com.roles.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roles.permission.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{

	
}

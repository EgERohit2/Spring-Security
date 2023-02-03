package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Role_table")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rolename;
	private Boolean inActive;
	@CreationTimestamp
	private LocalDate date;
	@ManyToMany(mappedBy = "role",fetch = FetchType.EAGER)
	private Set<User> user;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "Role_Permission", joinColumns = {
	@JoinColumn(name = "rid", referencedColumnName = "id") }, inverseJoinColumns = @JoinColumn(name = "pid", referencedColumnName = "id"))
	private List<Permission> permission;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public List<Permission> getPermission() {
		return permission;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	public Role(int id, String rolename, Set<User> user, List<Permission> permission) {
		super();
		this.id = id;
		this.rolename = rolename;
		this.user = user;
		this.permission = permission;
	}
	
	
}

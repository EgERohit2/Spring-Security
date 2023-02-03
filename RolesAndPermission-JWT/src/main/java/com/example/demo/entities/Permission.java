package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Permision_table")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String persmissionname;
	@ManyToMany(mappedBy = "permission",fetch = FetchType.EAGER)
	private List<Role> role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersmissionname() {
		return persmissionname;
	}
	public void setPersmissionname(String persmissionname) {
		this.persmissionname = persmissionname;
	}
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public Permission(int id, String persmissionname, List<Role> role) {
		super();
		this.id = id;
		this.persmissionname = persmissionname;
		this.role = role;
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
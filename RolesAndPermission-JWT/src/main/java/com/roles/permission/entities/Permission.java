package com.roles.permission.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Permision_table")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String persmissionname;
	@ManyToOne(targetEntity = Permission.class)
	private Role role;

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

	public Permission(int id, String persmissionname) {
		super();
		this.id = id;
		this.persmissionname = persmissionname;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

}

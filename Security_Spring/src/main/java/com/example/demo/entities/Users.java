package com.example.demo.entities;

public class Users {

	String userName;
	String password;
	String moileNo;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoileNo() {
		return moileNo;
	}
	public void setMoileNo(String moileNo) {
		this.moileNo = moileNo;
	}
	public Users(String userName, String password, String moileNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.moileNo = moileNo;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

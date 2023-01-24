package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;

@Service
public class UsersServices {

	List<Users> list = new ArrayList<>();
	
	public  UsersServices() {
		list.add(new Users("rohit","rohit101241@gmail.com","8080980450"));
		list.add(new Users("deepak","deepak@gmail.com","091237190"));
	}
	
	public List<Users> getAll(){
		return this.list;
	}
	
	public Users getByUsersName(String name) {
		return this.list.stream().filter((user)-> user.getName().equals(name)).findAny().get();
	}

	
	


	
}

package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;

@Service
public class UsersServices {

List<Users> list = new ArrayList<>();
public UsersServices() {
	list.add(new Users("rohit", "lllll", "rohitjadhav@nimapinfotech.com"));
	list.add(new Users("deepak", "kkkk", "deepakbehera@nimpinfotech.com"));
}

public List<Users> getAll() {
	return this.list;
}

public Users getUserByName(String userName) {
	return this.list.stream().filter((user) -> user.getUserName().equals(userName)).findAny().orElseThrow();
}

public Users addUser(Users users) {
	this.list.add(users);
	return users;
}

}

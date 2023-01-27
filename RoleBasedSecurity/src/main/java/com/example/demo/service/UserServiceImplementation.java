package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void postData(User user) {

		User u = new User();
		u.setId((user.getId()));
		u.setPassword((passwordEncoder.encode(user.getPassword())));
		u.setRole((user.getRole()));
		u.setUsername((user.getUsername()));
		userRepository.save(u);
	}

}

package com.example.demo.component;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.JwtRequestRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private JwtRequestRepository jwtRequestRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtRequest users=this.jwtRequestRepository.findByUsername(username);
		System.out.println("##########        cuds      ###################");
		if(users==null)
		{
			throw new UsernameNotFoundException("404 not found");
		}

        return new CustomService(users);	

	}

}

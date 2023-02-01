package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.JwtRequest;
import com.example.demo.config.JwtResponse;
import com.example.demo.config.JwtUtil;
import com.example.demo.service.JwtDetailsService;

@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	
	@Autowired
	private JwtDetailsService userDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createUserToken(@RequestBody JwtRequest authenticationRequest)throws Exception{
	//testing System.out.println("test1"); 
	authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
	//testing operation System.out.println("test2");
	  final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
	 final String token=jwtTokenUtil.generateToken(userDetails);
	  return ResponseEntity.ok(new JwtResponse(token));
		
		
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("user blocked",e);
		}catch (BadCredentialsException e) {
			throw new Exception("invalid credentials",e);
		}
		
	}
}

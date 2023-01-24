package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/others")
public class OtherControllers {

	@GetMapping("/home")
	public String home() {
		return "Home controller";
	}

	@GetMapping("/login")
	public String login() {
		return "login controller";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello controller";
	}
}

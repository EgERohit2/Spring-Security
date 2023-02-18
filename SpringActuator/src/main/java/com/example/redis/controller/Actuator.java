package com.example.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.helper.Student;
@RestController
public class Actuator {
	
	@Autowired	
	private Student student;
	
	@GetMapping("/getStudent")
	public Map<String,String> getData(){
		return Map.of("Name","rohit jadhav");
	}
}

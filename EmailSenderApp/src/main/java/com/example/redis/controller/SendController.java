package com.example.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.entity.EmailDetails;
import com.example.redis.service.EmailService;

@RestController
public class SendController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public String sendEmail(@RequestBody EmailDetails emailDetails) {
		this.emailService.email(emailDetails);
		return "mail sent";
	}
	@PostMapping("/sentwithattachment")
	public String sendEmailWithAttachment(@RequestBody EmailDetails emailDetails) {
		this.emailService.email(emailDetails);
		return "mail sent";
	}
}

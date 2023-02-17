package com.example.redis.service;

import com.example.redis.entity.EmailDetails;

public interface EmailService {

	String email(EmailDetails emailDetails);
	
	String emailWithAttachment(EmailDetails emailDetails);
}

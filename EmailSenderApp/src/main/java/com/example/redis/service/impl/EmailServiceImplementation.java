package com.example.redis.service.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.redis.entity.EmailDetails;
import com.example.redis.service.EmailService;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	private String sender;

	@Override
	public String email(EmailDetails emailDetails) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(sender);
			message.setTo(emailDetails.getRecipient());
			message.setText(emailDetails.getMessageBody());
			message.setSubject(emailDetails.getSubject());

			javaMailSender.send(message);
			return "mail sent successfully";
		} catch (Exception e) {
			return "error while sending";
		}

	}

	@Override
	public String emailWithAttachment(EmailDetails emailDetails) {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(message, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getRecipient());
			mimeMessageHelper.setText(emailDetails.getMessageBody());
			mimeMessageHelper.setSubject(emailDetails.getSubject());

			FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			javaMailSender.send(message);
			return "message sent successfuly";
		} catch (Exception e) {

		}
		return "error while sending";
	}

	

}

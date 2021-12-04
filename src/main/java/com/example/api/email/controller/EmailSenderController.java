package com.example.api.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.email.model.EmailModel;
import com.example.api.email.service.EmailSenderService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/apis/")
public class EmailSenderController {
	
	@Autowired
	EmailSenderService emailSender;
	
	@PostMapping("email")
	
	public boolean sendEmail(EmailModel emailModel) throws MessagingException {
		emailSender.sendEmailWithAttachment(emailModel);
		return true;
	}
}

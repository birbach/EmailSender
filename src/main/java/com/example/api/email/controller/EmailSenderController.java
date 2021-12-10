package com.example.api.email.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.email.model.EmailModel;
import com.example.api.email.model.SimpleEmailModel;
import com.example.api.email.repository.EmailRepository;
import com.example.api.email.service.EmailSenderService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/apis/")
public class EmailSenderController {
	
	@Autowired
	EmailSenderService emailSender;
	
	@Autowired
	EmailRepository emailRepository;
	
	@PostMapping(value ="email")
	public boolean sendEmail(@RequestBody EmailModel emailModel) throws MessagingException {
		emailSender.sendEmailWithAttachment(emailModel);
		return true;
	}
	
	@PostMapping(value="simpleEmail")
	public SimpleEmailModel simpleEmail(@RequestBody SimpleEmailModel simpleMailModel) throws MessagingException{
		SimpleEmailModel newSimpleMailModel=null;
		emailSender.sendSimpleEmail(simpleMailModel);
		newSimpleMailModel=emailRepository.save(simpleMailModel);
		return newSimpleMailModel;
	}
	
}

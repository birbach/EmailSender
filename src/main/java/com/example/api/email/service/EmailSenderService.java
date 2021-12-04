package com.example.api.email.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.api.email.model.EmailModel;

@Service
public class EmailSenderService {

	@Autowired
    private JavaMailSender mailSender;


    public void sendEmailWithAttachment(EmailModel emailModel) throws MessagingException {
    	
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("birbach18youssef@gmail.com");
        mimeMessageHelper.setTo(emailModel.getToEmail());
        mimeMessageHelper.setText(emailModel.getBody());
        mimeMessageHelper.setSubject(emailModel.getSubject());

        FileSystemResource fileSystem
                = new FileSystemResource(new File(emailModel.getAttachment()));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

         mailSender.send(mimeMessage);
        System.out.println("Mail Send...");

    }
}

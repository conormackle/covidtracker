package com.cmackle.covidtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String msg, String Subject, String recipient) {

        SimpleMailMessage emailMsg = new SimpleMailMessage();
        emailMsg.setTo(recipient);

        emailMsg.setSubject(Subject);
        emailMsg.setText(msg);

        javaMailSender.send(emailMsg);

    }

}

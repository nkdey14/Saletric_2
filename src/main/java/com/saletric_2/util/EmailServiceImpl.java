package com.saletric_2.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String to, String sub, String emailBody) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(to);
		mailMessage.setSubject(sub);
		mailMessage.setText(emailBody);
		
		javaMailSender.send(mailMessage);
		
	}	
}

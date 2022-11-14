package com.saletric_2.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath) {
			MimeMessage message = sender.createMimeMessage();
			try {
				MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
				messageHelper.setTo(toAddress);
				messageHelper.setSubject("Your purchase is successful!");
				messageHelper.setText("Dear Customer, \n\nThanks for shopping with us! Please find the attached bill for your reference. \n\nSee you soon! \n\n\nThanks & Regards,\n\nMarketing Support Team\nNK Solutions Pvt. Ltd.");
				messageHelper.addAttachment("Billing Details", new File(filePath) );
				sender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
	}
}

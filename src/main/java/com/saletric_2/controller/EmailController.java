package com.saletric_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saletric_2.dto.EmailData;
import com.saletric_2.util.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/sendEmail")
	public String getEmailId(@RequestParam("email") String email, Model model) {
		
		model.addAttribute("email", email);
		
		return "composeEmail";
	}
	
	@PostMapping("/triggerEmail")
	public String sendEmail(EmailData email, Model model) {
		
		emailService.sendEmail(email.getEmail(), email.getSubject(), email.getContent());
		
		model.addAttribute("msg", "Email sent successfully!");
		
		return "composeEmail";
	}
}

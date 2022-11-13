package com.saletric_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saletric_2.entities.Contact;
import com.saletric_2.entities.Lead;
import com.saletric_2.services.ContactService;
import com.saletric_2.services.LeadService;
import com.saletric_2.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ContactService contactService;

	// http://localhost:9090/Cintrix/viewLeadPage
	@GetMapping("/viewLeadPage")
	public String showviewLeadPage() {
		
		return "newLead";
	}
	
	
	@PostMapping("/saveLead")
	public String saveLeadDetails(@ModelAttribute("lead") Lead l, Model model) {
		
		leadService.saveLeadData(l);
		
		emailService.sendEmail(l.getEmail(), "Registration Successful!", "Dear Customer, \n\nThanks for Registering with us!.\n\n\nThanks & Regards,\n\nMarketing Support Team\nNK Solutions Pvt. Ltd.");
		
		model.addAttribute("msg", "Lead saved successfully!");
		
		model.addAttribute("lead", l);
		
		return "leadInfo";
	}
	
	@GetMapping("/viewAllLeads")
	public String getAllLeads(Model model) {
		
		List<Lead> leads = leadService.listAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/updateLead")
	public String getLeadInfo(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		model.addAttribute("lead", lead);
		
		return "updateLead";
	}
	
	@PostMapping("/updateLeadInfo")
	public String updateLeadData(@ModelAttribute("lead") Lead l, Model model) {
		
		leadService.saveLeadData(l);
		
		model.addAttribute("msg", "Lead updated successfully!");
		
		List<Lead> leads = leadService.listAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/deleteLead")
	public String deleteLeadData(@RequestParam("id") int id, Model model) {
		
		leadService.deleteLeadInfo(id);
		
		model.addAttribute("msg", "Lead deleted successfully!");
		
		List<Lead> leads = leadService.listAllLeads();
		
		model.addAttribute("leads", leads);
		
		return "listLeads";
	}
	
	@GetMapping("/leadInfoPage")
	public String showLeadInfo(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		model.addAttribute("lead", lead);
		
		return "leadInfo";
	}
	
	@GetMapping("/convertLead")
	public String convertLeadToContact(@RequestParam("id") int id, Model model) {
		
		Lead lead = leadService.findLeadById(id);
		
		Contact c = new Contact();
		
		c.setFirstName(lead.getFirstName());
		c.setLastName(lead.getLastName());
		c.setEmail(lead.getEmail());
		c.setMobile(lead.getMobile());
		c.setCity(lead.getCity());
		c.setSource(lead.getSource());
		
		contactService.saveContact(c);
		
		leadService.deleteLeadInfo(id);
		
		model.addAttribute("msg", "Contact saved successfully!");
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
}

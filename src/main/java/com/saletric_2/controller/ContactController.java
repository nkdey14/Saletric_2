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
import com.saletric_2.services.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewAllContacts")
	public String getAllContacts(Model model) {
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/updateContact")
	public String getContactInfo(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "updateContact";
	}
	
	@PostMapping("/updateContactInfo")
	public String updateContactDetails(@ModelAttribute("contact") Contact c, Model model) {
		
		contactService.saveContact(c);
		
		model.addAttribute("msg", "Contact updated successfully!");
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContactInfo(@RequestParam("id") int id, Model model) {
		
		contactService.deleteContactDetails(id);
		
		model.addAttribute("msg", "Contact deleted successfully!");
		
		List<Contact> contacts = contactService.findAllContacts();
		
		model.addAttribute("contacts", contacts);
		
		return "listContacts";
	}
	
	@GetMapping("/contactInfoPage")
	public String viewContactInfo(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "contactInfo";
	}
	
	@GetMapping("/viewContactPage")
	public String getContactData() {
		
		return "findContact";
	}
	
	@PostMapping("/searchContact")
	public String getContactDetails(@RequestParam("mobile") long mobile, Model model) {
		
		Contact contact = contactService.getContactByMobile(mobile);
		
		if(contact != null) {
			
			model.addAttribute("contact", contact);
			
			return "contactInfo";
			
		}else {
			
			model.addAttribute("msg", "No record found!");
			
			return "findContact";
		}
	}
}

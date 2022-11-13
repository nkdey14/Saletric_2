package com.saletric_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saletric_2.entities.Contact;
import com.saletric_2.repositories.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContact(Contact c) {
		
		contactRepo.save(c);
		
	}

	@Override
	public List<Contact> findAllContacts() {
		
		List<Contact> contacts = contactRepo.findAll();
		
		return contacts;
	}

	@Override
	public Contact findContactById(int id) {
		
		Contact contact = contactRepo.findById(id).get();
		
		return contact;
		
	}

	@Override
	public void deleteContactDetails(int id) {
		
		contactRepo.deleteById(id);
		
	}

	@Override
	public Contact getContactByMobile(long mobile) {
		
		Contact contact = contactRepo.findContactByMobile(mobile);
		
		return contact;
	}

}

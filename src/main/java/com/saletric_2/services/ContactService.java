package com.saletric_2.services;

import java.util.List;

import com.saletric_2.entities.Contact;

public interface ContactService {

	public void saveContact(Contact c);

	public List<Contact> findAllContacts();

	public Contact findContactById(int id);

	public void deleteContactDetails(int id);

	public Contact getContactByMobile(long mobile);


}

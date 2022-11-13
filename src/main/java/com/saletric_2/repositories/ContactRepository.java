package com.saletric_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saletric_2.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public Contact findContactByMobile(long mobile);

}

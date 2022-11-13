package com.saletric_2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saletric_2.entities.Lead;
import com.saletric_2.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLeadData(Lead l) {
		
		leadRepo.save(l);
		
	}

	@Override
	public List<Lead> listAllLeads() {
		
		List<Lead> leads = leadRepo.findAll();
		
		return leads;
	}

	@Override
	public Lead findLeadById(int id) {
		
		Lead lead = leadRepo.findById(id).get();
		
		return lead;
		
	}

	@Override
	public void deleteLeadInfo(int id) {
		
		leadRepo.deleteById(id);
		
	}
}

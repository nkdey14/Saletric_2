package com.saletric_2.services;

import java.util.List;

import com.saletric_2.entities.Lead;

public interface LeadService {

	public void saveLeadData(Lead l);

	public List<Lead> listAllLeads();

	public Lead findLeadById(int id);

	public void deleteLeadInfo(int id);

}

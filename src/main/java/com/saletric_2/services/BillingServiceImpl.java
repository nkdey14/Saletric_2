package com.saletric_2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saletric_2.entities.Billing;
import com.saletric_2.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
	
	@Autowired
	private BillingRepository billingRepo;

	@Override
	public void saveBillingDetails(Billing b) {
		
		billingRepo.save(b);
	}

	@Override
	public List<Billing> findAllBills() {
		
		List<Billing> bills = billingRepo.findAll();
		
		return bills;
	}

	@Override
	public Billing getBillByMob(String mobile) {
		
		Billing bill = billingRepo.findBillByMobile(mobile);
		
		return bill;
	}

	@Override
	public Billing findBillById(int id) {
		
		Billing bill = billingRepo.findById(id).get();
		
		return bill;
		
	}
}

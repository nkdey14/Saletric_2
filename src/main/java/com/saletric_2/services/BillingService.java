package com.saletric_2.services;

import java.util.List;

import com.saletric_2.entities.Billing;

public interface BillingService {

	public void saveBillingDetails(Billing b);

	public List<Billing> findAllBills();

}

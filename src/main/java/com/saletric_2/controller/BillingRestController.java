package com.saletric_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saletric_2.entities.Billing;
import com.saletric_2.repositories.BillingRepository;

@RestController
@RequestMapping("/api/bills")
public class BillingRestController {
	
	@Autowired
	private BillingRepository billingRepo;
	
	// http://localhost:9090/Cintrix/api/bills
	@GetMapping
	public List<Billing> viewAllBills() {
		
		List<Billing> bills = billingRepo.findAll();
		
		return bills;
	}
	
	// http://localhost:9090/Cintrix/api/bills/bill
	@PostMapping("/bill")
	public void saveBill(@RequestBody Billing b) {
		
		billingRepo.save(b);
	}
	
	// http://localhost:9090/Cintrix/api/bills/bill
	@PutMapping("/bill")
	public void updateBill(@RequestBody Billing b) {
		
		billingRepo.save(b);
	}
	
	// http://localhost:9090/Cintrix/api/bills/bill/3
	@DeleteMapping("/bill/{id}")
	public void deleteBill(@PathVariable("id") int id) {
		
		billingRepo.deleteById(id);
	}
	
	//Exposing web services
	
	// http://localhost:9090/Cintrix/api/bills/bill/2
	@GetMapping("/bill/{id}")
	public Billing getBillDetails(@PathVariable("id") int id) {
		
		Billing bill = billingRepo.findById(id).get();
		
		return bill;
	}

}

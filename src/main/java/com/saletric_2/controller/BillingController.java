package com.saletric_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saletric_2.dto.PrintBill;
import com.saletric_2.entities.Billing;
import com.saletric_2.entities.Contact;
import com.saletric_2.services.BillingService;
import com.saletric_2.services.ContactService;
import com.saletric_2.util.EmailUtil;
import com.saletric_2.util.PDFGenerator;

@Controller
public class BillingController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private PDFGenerator pdfGenerator;
	
	@Autowired
	private EmailUtil emailUtil;
	
	
	@GetMapping("/generateBill")
	public String showBillingPage(@RequestParam("id") int id, Model model) {
		
		Contact contact = contactService.findContactById(id);
		
		model.addAttribute("contact", contact);
		
		return "generateBill";
	}
	
	@PostMapping("/saveBill")
	public String createBill(PrintBill bill, Model model) {
		
		Billing b = new Billing();
		
		b.setFirstName(bill.getFirstName());
		b.setLastName(bill.getLastName());
		b.setEmail(bill.getEmail());
		b.setMobile(bill.getMobile());
		b.setCity(bill.getCity());
		b.setProduct(bill.getProduct());
		b.setQuantity(bill.getQuantity());
		b.setPrice(bill.getPrice());
		
		String filePath = "E:\\PSA SpringBoot Programs\\saletric_2\\bills\\bill"+"_"+bill.getFirstName()+"_"+bill.getLastName()+".pdf";
		
		billingService.saveBillingDetails(b);
		
		pdfGenerator.generateItinerary(bill, filePath);
		
		emailUtil.sendItinerary(bill.getEmail(), filePath);
		
		model.addAttribute("msg", "Bill generated successfully!");
		
		model.addAttribute("bill", b);
		
		return "billingInfo";
	}
	
	@GetMapping("/viewAllBills")
	public String getAllBills(Model model) {
		
		List<Billing> bills = billingService.findAllBills();
		
		model.addAttribute("bills", bills);
		
		return "listBills";
	}
	
	@GetMapping("/searchBill")
	public String getBillingInfo() {
		
		return "findBill";
	}
	
	@PostMapping("/searchBillDetails")
	public String getBillingData(@RequestParam("mobile") String mobile, Model model) {
		
		Billing bill = billingService.getBillByMob(mobile);
		
		if(bill != null) {
			
			model.addAttribute("bill", bill);
			
			return "billingInfo";
			
		}else {
			
			model.addAttribute("msg", "No record found!");
			
			return "findBill";
		}
	}
	
	@GetMapping("/billInfoPage")
	public String showBillingData(@RequestParam("id") int id, Model model) {
		
		Billing bill = billingService.findBillById(id);
		
		model.addAttribute("bill", bill);
		
		return "billingInfo";
	}
}

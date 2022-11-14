package com.saletric_2.util;

import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.saletric_2.dto.PrintBill;

@Component
public class PDFGenerator {

	public void generateItinerary(PrintBill bill, String filePath) {
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			
			document.open();
			document.add(generateTable(bill));
			document.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(PrintBill bill) {
		
		 PdfPTable table = new PdfPTable(2);
		 PdfPCell cell;
		 
		 cell = new PdfPCell(new Phrase("\tNK Solutions Pvt. Ltd."));
		 cell.setColspan(2);
		 table.addCell(cell);
		 
		 cell = new PdfPCell(new Phrase("\tBilling Details"));
		 cell.setColspan(2);
		 table.addCell(cell);
		 
		 table.addCell("First Name");
		 table.addCell(bill.getFirstName());
		 

		 table.addCell("Last Name");
		 table.addCell(bill.getLastName());
		 

		 table.addCell("Email Id");
		 table.addCell(bill.getEmail());
		 

		 table.addCell("Mob no.");
		 table.addCell(bill.getMobile());
		 

		 table.addCell("City");
		 table.addCell(bill.getCity());
		 
		
		 cell = new PdfPCell(new Phrase("\tProduct Details"));
		 cell.setColspan(2);
		 table.addCell(cell);

		 table.addCell("Product");
		 table.addCell(bill.getProduct());
		 

		 table.addCell("Quantity");
		 table.addCell(bill.getQuantity());
		 

		 table.addCell("Price");
		 table.addCell(bill.getPrice().toString());
		 
		 return table;
	}
}

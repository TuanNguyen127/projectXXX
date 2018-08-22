package com.AssignmentSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AssignmentSpringBoot.Repository.InvoiceRepository;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@RequestMapping("/admin-invoice")
	public String adminInvoice(Model model) {
		model.addAttribute("Invoice", invoiceRepository.findAll());
		return "adminInvoice";
	}
}

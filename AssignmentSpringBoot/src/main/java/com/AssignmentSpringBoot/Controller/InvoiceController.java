package com.AssignmentSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AssignmentSpringBoot.Repository.InvoiceRepository;

@Controller
public class InvoiceController {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@RequestMapping("/admin/invoice")
	public String adminInvoice(Model model) {
		model.addAttribute("Invoices", invoiceRepository.findAll(Sort.by(Direction.DESC, "idinvoice")));
		return "adminInvoice";
	}
	
	@RequestMapping("/admin/invoicedetail/{id}")
	public String invoiceDetail(@PathVariable(value="id") Integer idinvoice, Model model) {
		model.addAttribute("Invoice", invoiceRepository.getOne(idinvoice));
		return "invoice-detail";
	}
	
	@RequestMapping("/admin/delete-invoice/{id}")
	public String deleteInvoice(@PathVariable(value="id") Integer idinvoice, Model model) {
		invoiceRepository.deleteById(idinvoice);
		return "redirect:/admin/invoice";
	}
}

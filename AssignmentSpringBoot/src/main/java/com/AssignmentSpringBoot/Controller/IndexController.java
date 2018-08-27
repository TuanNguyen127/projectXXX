package com.AssignmentSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.AssignmentSpringBoot.Entity.Product;
import com.AssignmentSpringBoot.Repository.ProductRepository;

@Controller
public class IndexController {
	
	@Autowired
	private ProductRepository productRepository;
	
	//product custom hiển thị
	@RequestMapping("")
	public String Product(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("Products", products);
		return "index";
	}
}

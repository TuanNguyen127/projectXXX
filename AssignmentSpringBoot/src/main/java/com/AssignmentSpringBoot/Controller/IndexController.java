package com.AssignmentSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.AssignmentSpringBoot.Entity.Product;
import com.AssignmentSpringBoot.Repository.ProductRepository;

@Controller
public class IndexController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/")
	public String Index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/detail")
	public String productDetail(Model model, @RequestParam("id") int productid) {
		Product product = productRepository.findById(productid).get();
		model.addAttribute("product",product);
		return "detail";
	}
}

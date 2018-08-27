package com.AssignmentSpringBoot.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssignmentSpringBoot.Entity.Product;
import com.AssignmentSpringBoot.Model.ProductModel;
import com.AssignmentSpringBoot.Repository.ProductRepository;

@Controller
public class DetailController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Environment env;
	
//	//đỗ ra slide
//	@RequestMapping("/detail")
//	public String Detail(Model model) {
//		List<Product> products = productRepository.findAll();
//		model.addAttribute("Products", products);
//		return "detail";
//	}
	
	//load ảnh lên hiển thị
	@RequestMapping("/image/{filename}")
	public @ResponseBody byte[] getImage(@PathVariable("filename") String filename) {
		File file = new File(env.getProperty("vitriluufile") + "/" + filename);
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//lấy chi tiết từ ID
	@RequestMapping("/detail/{idproduct}")
	public String idDetail(@PathVariable int idproduct, Model model) {
		Optional<Product> product = productRepository.findById(idproduct);
		ProductModel productModel = new ProductModel();
		if (product.isPresent()) {
			productModel.setProduct(product.get());
			model.addAttribute("Detail", productModel);	
		}
		return "detail";
	}
}

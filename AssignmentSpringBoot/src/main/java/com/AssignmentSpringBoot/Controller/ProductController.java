package com.AssignmentSpringBoot.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.AssignmentSpringBoot.Entity.Product;
import com.AssignmentSpringBoot.Model.ProductModel;
import com.AssignmentSpringBoot.Repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Environment env;
	
	//hiển thị
	@RequestMapping("/admin/product")
	public String adminProduct(Model model) {
		model.addAttribute("Products", productRepository.findAll(Sort.by(Direction.DESC, "idproduct")));
		return "adminProduct";
	}
	
	//load font thêm
	@RequestMapping("/admin/addnew-product")
	public String adminAddNewProduct(Model model) {
		model.addAttribute("ProductNew", new ProductModel());
		return "addNewProduct";
	}
	
	//thêm product
	@RequestMapping(value= "/admin/saveProduct", method=RequestMethod.POST)
	public String doSaveUser(@ModelAttribute("ProductNew") ProductModel productModel, Model model) {
		try {
			MultipartFile multipartFile = productModel.getMultipartFile();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File(this.getFolderUpload(), fileName);
			multipartFile.transferTo(file);
			productModel.getProduct().setImage(fileName);
			productRepository.save(productModel.getProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/product";
	}
	
	//vị trí ảnh lưu
	public File getFolderUpload() {
		File folderUpload = new File(env.getProperty("vitriluufile"));
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
	
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
	
	//xóa product
	@RequestMapping("/admin/del-product/{idproduct}")
	public String DelProduct(@PathVariable int idproduct) {
		productRepository.deleteById(idproduct);
		return "redirect:/admin/product";
	}
	
	//get id into font edit
	@RequestMapping("/admin/edit-product/{idproduct}")
	public String editProduct(@PathVariable int idproduct, Model model) {
		Optional<Product> product = productRepository.findById(idproduct);
		ProductModel productModel = new ProductModel();
		if (product.isPresent()) {
			productModel.setProduct(product.get());
			model.addAttribute("productModel", productModel);
		}
		return "adminEditProduct";
	}
		
	//Lưu lại sau khi đã edit
	@RequestMapping("/admin/EditProductProcess")
	public String doEditUser(@ModelAttribute("productModel") ProductModel productModel, Model model) {
		Optional<Product> product = productRepository.findById(productModel.getProduct().getIdproduct());
		if(productModel.getMultipartFile().isEmpty()) {
			String oldAvatarName = product.get().getImage();
			productModel.getProduct().setImage(oldAvatarName);
			productRepository.save(productModel.getProduct());
		}else {
			try {
				MultipartFile multipartFile = productModel.getMultipartFile();
				String fileName = multipartFile.getOriginalFilename();
				File file = new File(this.getFolderUpload(), fileName);
				multipartFile.transferTo(file);
				productModel.getProduct().setImage(fileName);
				productRepository.save(productModel.getProduct());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/admin/product";
	}
	
	//hiển thị lên trang product
	@RequestMapping("/product")
	public String Index(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products",products);
		return "product";
	}
}

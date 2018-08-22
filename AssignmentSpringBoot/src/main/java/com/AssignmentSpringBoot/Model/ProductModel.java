package com.AssignmentSpringBoot.Model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.AssignmentSpringBoot.Entity.Product;

public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private Product product;
	private MultipartFile multipartFile;
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public MultipartFile getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}
	
	
}

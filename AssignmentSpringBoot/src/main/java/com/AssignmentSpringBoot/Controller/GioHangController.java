package com.AssignmentSpringBoot.Controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.AssignmentSpringBoot.Entity.Product;
import com.AssignmentSpringBoot.Repository.ProductRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class GioHangController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping(value = "/addtocart/{id}")
	@ResponseBody
	public String addToCart(@PathVariable(value = "id") int id, HttpServletResponse response,
			@CookieValue(required = false, value = "cart") String cart) {
		try {
			Product product = productRepository.findById(id).get();
			if (cart != null) {
				cart = URLDecoder.decode(cart, "UTF-8");
			}
			cart = themSPVaoGH(cart, product);
			Cookie cartCookie = new Cookie("cart", URLEncoder.encode(cart, "UTF-8"));
			cartCookie.setMaxAge(1000000000); // set expire time to 10000+ sec
			cartCookie.setPath("/");
			response.addCookie(cartCookie); // put cookie in response
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping(value = "/show-cart")
	public String showCart(Model model, @CookieValue(required = false, value = "cart") String cart) {
		try {
			if (cart != null) {
				cart = URLDecoder.decode(cart, "UTF-8");
			}
			model.addAttribute("products", layDSSP(cart));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "show-cart";
	}
	
	@GetMapping(value = "/removefromcart/{id}/{number}")
	@ResponseBody
	public String removeFromCart(HttpServletResponse response,
			@PathVariable(value="id") int productId,
			@PathVariable(value="number") int number,
			@CookieValue(value="cart", required=false) String cart) {
		try {
			cart = URLDecoder.decode(cart, "UTF-8");
			cart = xoaSPKhoiGH(cart, productId);
			Cookie cartCookie = new Cookie("cart", URLEncoder.encode(cart, "UTF-8"));
			cartCookie.setMaxAge(1000000000); // set expire time to 10000+ sec
			cartCookie.setPath("/");
			response.addCookie(cartCookie); // put cookie in response
			return "success";
		}catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	private String themSPVaoGH(String gioHang, Product product)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> listPr;
		if (gioHang == null) {
			listPr = new ArrayList<>();
			product.setQuantity(1);
			listPr.add(product);
			gioHang = objectMapper.writeValueAsString(listPr);
			System.out.println(gioHang);
			return gioHang;
		}
		listPr = objectMapper.readValue(gioHang, new TypeReference<List<Product>>() {
		});
		boolean coSPNayTrongGH = false;
		for (Product x : listPr) {
			if (x.getIdproduct() == product.getIdproduct()) {
				x.setQuantity(x.getQuantity() + 1);
				coSPNayTrongGH = true;
				break;
			}
		}
		if (!coSPNayTrongGH) {
			product.setQuantity(1);
			listPr.add(product);
		}
		gioHang = objectMapper.writeValueAsString(listPr);
		System.out.println(gioHang);
		return gioHang;
	}
	
	private String xoaSPKhoiGH(String gioHang, int productId) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> listPr = objectMapper.readValue(gioHang, new TypeReference<List<Product>>() {
		});
		Product toBeDeleted = null;
		for(Product x : listPr) {
			if(x.getIdproduct() == productId) {
				//listPr.remove(x); Note: Không thể chỉnh sửa một List khi đang lặp qua nó (Lỗi ConcurrentModificationException)
				toBeDeleted = x;
				break;
			}
		}
		listPr.remove(toBeDeleted);
		gioHang = objectMapper.writeValueAsString(listPr);
		System.out.println(gioHang);
		return gioHang;
	}
	
	private List<Product> layDSSP(String gioHang) throws JsonParseException, JsonMappingException, IOException{
		if(gioHang == null) {
			return null;
		}
		ObjectMapper objectMapper = new ObjectMapper();
		List<Product> listPr = objectMapper.readValue(gioHang, new TypeReference<List<Product>>() {});
		return listPr;
	}
}

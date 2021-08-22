package com.salambasha.medicare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.entities.Product;
import com.salambasha.medicare.services.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
    
	@Autowired
	ProductService productService;

//	@PostMapping("/{cart_id}")
//	public String showUserCart(@PathVariable int cart_id) {
//		
//		return "pages/cart/cart-page";
//	}
	
	
	@PostMapping("/cartPage")
	public String showCartPage(HttpSession session,Model model, @RequestParam("productId") long productId, @RequestParam("quantity") int quantity) {
		
		if(session.getAttribute("userId") != null) {
		Product product = 	productService.findById(productId);
		
		model.addAttribute("product", product);
			
			return "pages/cart/cart-page";
			
		}else {
			
			return"pages/login/login";
		}
		
		
		
	}

	
	@GetMapping("/address")
	public String showUserddressForm() {
		
		return "pages/cart/cart-address";
	}
	
	
//	@PostMapping("/orderder")
//
//	public String showCheckout() {
//		
//		return "pages/cart/order-summary";
//	}
	
	//@PostMapping("/checkout")
	@GetMapping("/payment")
	public String showPayment() {
		
		return "pages/cart/payment";
	}
	
	@PostMapping("/order-details")
	//@GetMapping("/order-details")
	public String showOrderDetails() {
		
		return "pages/cart/order-summary";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/success")
	public String showSuccess() {
		
		return "pages/cart/success";
	}
	
	
	
}

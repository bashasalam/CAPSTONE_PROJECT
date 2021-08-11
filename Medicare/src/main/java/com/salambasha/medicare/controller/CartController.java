package com.salambasha.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController {


	@GetMapping("/{cart_id}")
	public String showUserCart(@PathVariable int cart_id) {
		
		return "pages/cart/cart-page";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/checkout")
	public String showCheckout() {
		
		return "pages/cart/check-out";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/payment")
	public String showPayment() {
		
		return "pages/cart/payment";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/order-details")
	public String showOrderDetails() {
		
		return "pages/cart/order-summary";
	}
	
	//@PostMapping("/checkout")
	@GetMapping("/success")
	public String showSuccess() {
		
		return "pages/cart/success";
	}
	
	
	
}

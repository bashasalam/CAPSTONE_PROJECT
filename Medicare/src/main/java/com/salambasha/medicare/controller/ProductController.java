package com.salambasha.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

	@GetMapping("/{productId}")
	public String productDetailsShow(@PathVariable int productId) {
		
		return "/pages/products/product-page";
	}
	
}

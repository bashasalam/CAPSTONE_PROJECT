package com.salambasha.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/login")
	public String showAdminLogin() {
		
		return "pages/admin/login";
	}

	@PostMapping("/dashboard")
	public String showAdminDashboard() {
		
		return "pages/admin/dashboard";
	}
	
	@GetMapping("/add-madicine")
	public String showAddMadicine() {
		
		return "pages/admin/add-madicine";
	}

	@GetMapping("/add-products")
	public String showAddProducts() {
		
		return "pages/admin/add-products";
	}

	
}

package com.salambasha.medicare.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.entities.Category;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Category category = new Category();
	
	@Autowired
	CategoryRepository cateRepo;
	
	@GetMapping("/login")
	public String showAdminLogin() {
		
		return "pages/admin/login";
	}

	@RequestMapping("/dashboard")
	public String showAdminDashboard() {
		
		return "pages/admin/dashboard";
	}

	@GetMapping
	public String showAdminDashboards(Model model) {
	List<Category> categories = cateRepo.findAll();
		
		
		
		model.addAttribute("categoryList", categories);
		
		return "pages/admin/dashboard";
	}
	
	@GetMapping("/table")
	public String showTables() {
		
		return "pages/admin/tables";
	}

	@GetMapping("/add-madicine")
	public String showAddMadicine() {
		
		return "pages/admin/add-madicine";
	}
	
	@GetMapping("/add-category")
	public String showAddCategory(Model model) {
		
		model.addAttribute("categoryFormData", category);
		
		return "pages/admin/add-category";
	}

	@GetMapping("/add-products")
	public String showAddProducts() {
		
		return "pages/admin/add-products";
	}

	
}

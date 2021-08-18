package com.salambasha.medicare.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryRepository cateRepo;
	@Autowired
	CategoryService categoryService;
	
	Category category = new Category();
	
	@PostMapping("/save")
	public String saveCategory( Category category,Model model) {
		
		cateRepo.save(category);
		
		return "redirect:/admin";
	}
	
//	@GetMapping("")
//	public String deleteCategory(@RequestParam long deleteId) {
//		
//		categoryService.deleteCategory(deleteId);
//		
//	  return "redirect:/admin";
//	}
	
	@GetMapping("")
	public String editCategory(@RequestParam long editId, Model model) {
		
			
		Category category = categoryService.findByid(editId);
		
		model.addAttribute("editCategory", category);
		
		return "pages/admin/edit-category";
		
	}
	
	@PostMapping("/update")
	public String updateCategory(@RequestParam("categoryName") String categoryName, @RequestParam("categoryId") long categoryId, Model model) {
		
		categoryService.updateCategory(categoryName,categoryId);
		System.out.println("updated");
		
		return "redirect:/admin";
		
	}
	
	

}

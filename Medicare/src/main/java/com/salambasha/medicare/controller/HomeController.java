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
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	CategoryRepository cateRepo;

    @GetMapping
	public String showHome(Model model) {
    	List<Category> categories = cateRepo.findAll();
		
		
		
		model.addAttribute("categoryList", categories);
		return "pages/home";
	}
    

 
}

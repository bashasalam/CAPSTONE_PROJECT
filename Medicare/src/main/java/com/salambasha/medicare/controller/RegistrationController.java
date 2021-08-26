package com.salambasha.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salambasha.medicare.entities.User;

@Controller
@RequestMapping("MEDICARE/register")
public class RegistrationController {
	User user = new User();
	@GetMapping("/new")
	public String showRegistrationPage(Model model) {
		//User user1 = new User();
		
		
		model.addAttribute("userFormData", new User());
		
		return "pages/registration/registration";
		
	}
	
	

}

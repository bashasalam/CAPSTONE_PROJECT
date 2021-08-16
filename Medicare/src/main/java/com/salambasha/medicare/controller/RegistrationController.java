package com.salambasha.medicare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@GetMapping("/new")
	public String showRegistrationPage() {
		return "pages/registration/registration";
	}
	
	

}

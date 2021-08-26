package com.salambasha.medicare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("MEDICARE/login")
public class LoginController {
	
	@GetMapping("/new")
	public String showLogin(HttpSession session, Model model) {
		if(session.getAttribute("userName")!=null) {
			
			//System.out.println(session.getAttribute("userName"));
			model.addAttribute("kindlyLoginNow", "Kindly Login");
			return "pages/login/login";
		}else {
		
		return "pages/login/login";
		
		}
	}
	
 
  
	

}

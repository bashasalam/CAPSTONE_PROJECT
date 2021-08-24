package com.salambasha.medicare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.User;
import com.salambasha.medicare.services.CartService;
import com.salambasha.medicare.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/")
	public String showUserHome() {
		
		return "pages/users/home";
	}
	 
//	  public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) {
//	        model.addAttribute("attribute", "redirectWithRedirectPrefix");
//	        return new ModelAndView("redirect:/redirectedUrl", model);
//	    }
	
	@PostMapping("/save")
	public String saveUser(Model model,User user,HttpSession session ,@RequestParam("password") String password, @RequestParam("password2") String password2) {
	
		
		if(password.equals(password2)) {
			
			
			userService.save(user);
		
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getFullName());
			//session.setAttribute("theCart", cart.);
			
		//	model.addAttribute("kindlyLoginNow", "Kindly Login Now");
			
			return "redirect:/login/new";
			 
		}else {
			
			model.addAttribute("passwordsnotmatched", "passwords are not matching");
			model.addAttribute("userFormData", user);
			
			return "pages/registration/registration";
			
		}
		
		
			
	}
	
	 @PostMapping("/logincheck")
	  public String loginCheck(@RequestParam("email") String email,@RequestParam("password") String password,HttpSession session,Model model) {
		  //
//		  		HttpSession session=request.getSession();
//		  		session.setAttribute("userName", userName);
		 long existingCartId;
		 System.out.println(email);
		 System.out.println(password); 
		 
		  		User user = userService.loginCheck(email,password);
		  		
		  		System.out.print(user);
		  		
		  		if(session.getAttribute("theCart")!=null) {
		  			 existingCartId = (long)session.getAttribute("theCart");
		  			
		  		}else {
		  			
		  			 existingCartId = 0;
		  		}
		  		
		  	
		  	
		  	Cart existingCart = cartService.findByid(existingCartId);
		  		
		  		if((user != null) && (existingCart == null)) {
		  			int isActive = 1;
		  				session.setAttribute("userName", user.getFullName());
		  				session.setAttribute("userId", user.getUserId());
		  				cartService.save(user,isActive);
		  				Cart cart = cartService.findCart(user,isActive);
		  				session.setAttribute("theCart", cart.getCartId());
		  				System.out.println("coming here");
		  			
		  			return "redirect:/"; 
		  		}else if((user != null) && (existingCart != null)) {
		  			if(existingCart.getUser() == user) {
		  			
		  			int isActive = 1;
		  			session.setAttribute("userName", user.getFullName());
	  				session.setAttribute("userId", user.getUserId());
	  				Cart cart = cartService.findCart(user,isActive);
	  				session.setAttribute("theCart", cart.getCartId());
	  				return "redirect:/"; 
		  			}else {
		  				int isActive = 1;
		  				session.setAttribute("userName", user.getFullName());
		  				session.setAttribute("userId", user.getUserId());
		  				cartService.save(user,isActive);
		  				Cart cart = cartService.findCart(user,isActive);
		  				session.setAttribute("theCart", cart.getCartId());
		  			
		  			return "redirect:/"; 
		  				
		  			}
		  		}else if ((user==null) && (existingCart!=null)){
		  			return "pages/login/login"; 
		  		}else {
		  			
		  			String obj = "Current Username and Password Mismatching";
					model.addAttribute("currentusernamepasswordmismatch", obj);
		  			return "pages/login/login"; 
		  		}
		  	} 
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 
		 
		 session.setAttribute("userName", null);
		 session.setAttribute("userId", null);
		// session.setAttribute("theCart", null);
		 //cart need to be change the isActive = 0; cart
		 
//		 long theCart = (long) session.getAttribute("theCart");
//		 
//		 
//		 Cart cart = cartService.findByid(theCart);
//		 
//		 cart.setIsActive(0);
//		 session.setAttribute("theCart",null);
		 
		 return "redirect:/";
	 }

	public User findById(long userId) {
		User user = userService.findById(userId);
		
		return user;
	}
	

} 

package com.salambasha.medicare.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.entities.User;
import com.salambasha.medicare.services.CartService;
import com.salambasha.medicare.services.UserService;

@Controller
@RequestMapping("MEDICARE/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CartService cartService;
	
	@Autowired
	ProductCountController productCountController;
	@GetMapping("/MEDICARE/")
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
			
			return "redirect:/MEDICARE/login/new";
			 
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
		System.out.println(session.getAttribute("theCart"));
		  		User user = userService.loginCheck(email,password);
		  		System.out.print(user);
		  		
		  		if(session.getAttribute("theCart")!=null) {
		            existingCartId = (long)session.getAttribute("theCart");
		        
		           
		       }else {
		           
		            existingCartId = 0;
		       }
		  		
		  		Cart existingCart = cartService.findByid(existingCartId);
		  		
		  		//int existingCart_isActive = existingCart.getIsActive();
		  		
		  		if((user!=null) && (existingCart!=null)) {
		  			
		            
		        //  if user.getUserId() = existingCart.
		           if(user==existingCart.getTheUser()) {
		        	   session.setAttribute("userName", user.getFullName());
			            session.setAttribute("userId", user.getUserId());
			            session.setAttribute("theCart", existingCart.getCartId());
			            System.out.println("Working here user has cart already");
			            
			            long user_id = user.getUserId();
			            long cart_id= existingCart.getCartId();
			            
			            
			            
						List<ProductCount> productsInCart = productCountController.findProductCounts(user_id,cart_id);
			      
					int noOfProductInCart = 	productsInCart.size();
					 session.setAttribute("noOfProductInCart", noOfProductInCart);
			           
		           }else {
		        	   int isActive = 1;
		        	   session.setAttribute("userName", user.getFullName());
			            session.setAttribute("userId", user.getUserId());
			            Cart cart = cartService.findSingleCart(user,isActive);
				  		session.setAttribute("theCart", cart.getCartId());
				  		System.out.println("Working here new cart careated");
				  		
				  		long user_id = user.getUserId();
			            long cart_id= cart.getCartId();
			            
			            
			            
						List<ProductCount> productsInCart = productCountController.findProductCounts(user_id,cart_id);
			           // System.out.println("check for active cart");
			            
			           // Cart cart = cartService.findByid()
					int noOfProductInCart = 	productsInCart.size();
					 session.setAttribute("noOfProductInCart", noOfProductInCart);
		           }
		            
		         //   session.setAttribute("theCart", existingCart.getCartId());
		            return "redirect:/MEDICARE/"; 
		  		}else if((user!=null)&&(existingCart==null)) {
		  					  		
		  			int isActive = 1;
		 	  		Cart exisTingCart = cartService.findSingleCart(user,isActive);
		 	  		System.out.println("Working here trying to find existing cart");
		  		
		  		if(exisTingCart==null) {
		  			System.out.println("confirmed no existing cart");
		  			cartService.save(user,isActive);
		  			Cart newCart = cartService.findSingleCart(user,isActive);
		  			session.setAttribute("theCart", newCart.getCartId());
		  			session.setAttribute("userName", user.getFullName());
		            session.setAttribute("userId", user.getUserId());
		  		}else {
		  			
		  			session.setAttribute("theCart", exisTingCart.getCartId());
		  			session.setAttribute("userName", user.getFullName());
		            session.setAttribute("userId", user.getUserId());
		            long user_id = user.getUserId();
		            long cart_id= exisTingCart.getCartId();
		            
		            
		            
					List<ProductCount> productsInCart = productCountController.findProductCounts(user_id,cart_id);
		           // System.out.println("check for active cart");
		            
		           // Cart cart = cartService.findByid()
				int noOfProductInCart = 	productsInCart.size();
				 session.setAttribute("noOfProductInCart", noOfProductInCart);
		  		}
		  		
		  		
		  		
		  		return "redirect:/MEDICARE/";
		  		}else if((user==null) && (existingCart!=null) ) {
		  			
		  			//session.setAttribute("theCart", null);
		  			String obj = "Current Username and Password Mismatching";
		  	         model.addAttribute("currentusernamepasswordmismatch", obj);
		  	           return "pages/login/login"; 
		  			
		  		
		  			
		  		}else {
		  			
		  			String obj = "Current Username and Password Mismatching";
		  	         model.addAttribute("currentusernamepasswordmismatch", obj);
		  	           return "pages/login/login"; 
		  			
		  		}
		  		
		  
		  		//return "pages/home";
		  	} 
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 
		 
		 session.setAttribute("userName", null);
		 session.setAttribute("userId", null);
		 session.setAttribute("theCart", null);
		 //cart need to be change the isActive = 0; cart
		 
//		 long theCart = (long) session.getAttribute("theCart");
//		 
//		 
//		 Cart cart = cartService.findByid(theCart);
//		 
//		 cart.setIsActive(0);
//		 session.setAttribute("theCart",null);
		 
		 return "redirect:/MEDICARE/";
	 }

	public User findById(long userId) {
		User user = userService.findById(userId);
		
		return user;
	}
	

} 

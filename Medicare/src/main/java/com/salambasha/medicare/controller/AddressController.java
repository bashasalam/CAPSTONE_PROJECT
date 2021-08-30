package com.salambasha.medicare.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salambasha.medicare.entities.Address;
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.services.AddressService;

@Controller
@RequestMapping("MEDICARE/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@Autowired
	ProductCountController productCountController;
	
	@PostMapping("/save")
	public String saveAddress(Address address, HttpSession session) {
		
		addressService.save(address);
//		
//		session.setAttribute("userId", user.getUserId());
//		session.setAttribute("userName", user.getFullName());
//		session.setAttribute("theCart", cart.getCartId());
		
		long userId = (long) session.getAttribute("userId");
		long cartId = (long) session.getAttribute("theCart");
		
		List<ProductCount> productCounts = productCountController.findProducts(cartId,userId);
		
		   // 2021-03-24 16:48:05.591
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  
		  System.out.println(timestamp);
		  
		for (ProductCount productCount : productCounts) {
			
			 System.out.println("working here");
			 System.out.println(productCount);
		//	productCount.setPurchaseTime(timestamp);
			 long countTableId = productCount.getCountTableId();
			 
			 
			 productCountController.updatePurchaseTime(timestamp,countTableId);
			 
			
		}
		
		
		
		
		
		return "redirect:/MEDICARE/cart/success";
	}
	
}

package com.salambasha.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salambasha.medicare.entities.Address;
import com.salambasha.medicare.services.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/save")
	public String saveAddress(Address address) {
		
		addressService.save(address);
		
		return "redirect:/cart/order-details";
	}
	
}

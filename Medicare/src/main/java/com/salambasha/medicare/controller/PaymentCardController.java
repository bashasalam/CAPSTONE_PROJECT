package com.salambasha.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salambasha.medicare.entities.Address;
import com.salambasha.medicare.entities.PaymentCard;
import com.salambasha.medicare.services.PaymentCardService;

@Controller
@RequestMapping("/MEDICARE/payment")
public class PaymentCardController {
	
	@Autowired
	PaymentCardService paymentCardService;
	
	@PostMapping("/card")
	public String savePaymentCard(Model model, PaymentCard paymentCard) {
		
		
		
		paymentCardService.save(paymentCard);
		//model.addAttribute("addressFromData", address);
		//model.addAttribute("paymentSuccessful", "Your Payment is Successfull");
		return "redirect:/MEDICARE/cart/address";		
	}

}

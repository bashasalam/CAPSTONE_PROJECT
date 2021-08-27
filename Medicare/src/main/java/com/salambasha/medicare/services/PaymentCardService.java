package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.PaymentCardRepository;
import com.salambasha.medicare.entities.PaymentCard;

@Service
public class PaymentCardService {

	@Autowired
	PaymentCardRepository paymentCardRepo;
	
	public void save(PaymentCard paymentCard) {
		// TODO Auto-generated method stub
		paymentCardRepo.save(paymentCard);
		
	}

}

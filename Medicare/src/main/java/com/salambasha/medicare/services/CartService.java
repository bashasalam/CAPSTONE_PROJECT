package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.CartRepository;
import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.User;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepo;
	
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		
		cartRepo.save(cart);
		
	}

	public void update(long theCart) {
		// TODO Auto-generated method stub
	//	cartRepo.update(theCart);
	}

	public void save(User user, int isActive) {
		// TODO Auto-generated method stub
		cartRepo.save(new Cart(user,isActive));
		
	}

}

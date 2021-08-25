package com.salambasha.medicare.services;

import java.util.List;

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

	public List<Cart> findCart(User user, int isActive) {
	
		List<Cart> carts = cartRepo.findCart(user,isActive);
		
		return carts;
	}

	public Cart findByid(long theCart) {
		
		Cart cart = cartRepo.findByid(theCart);
				return cart;
	}

	public Cart findSingleCart(User user, int isActive) {
		
		Cart cart = cartRepo.findSingleCart(user,isActive);
		
		return cart;
	}

	public void changeIsActive( int isActive,long availableCartId) {
		
		cartRepo.changeIsActive(isActive,availableCartId);
		
	}

}

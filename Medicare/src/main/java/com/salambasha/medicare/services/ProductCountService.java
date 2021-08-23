package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.ProductCountRepository;
import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.entities.User;

@Service
public class ProductCountService {

	@Autowired
	ProductCountRepository productCountRepo;

	public void save(ProductCount productCount) {
		// TODO Auto-generated method stub
		productCountRepo.save(productCount);
	}

	public void save(long productId, int count) {
		// TODO Auto-generated method stub
		productCountRepo.save(new ProductCount(productId,count));
		
	}

	public void save(long productId, int count, Cart cart, User user) {
		
		productCountRepo.save(new ProductCount(productId,count,cart,user));
		
		
	}
	
	//productCountRepo.save()
	
}

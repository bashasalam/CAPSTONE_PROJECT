package com.salambasha.medicare.services;

import java.util.List;

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

	public List<ProductCount> findProducts(long theCart, long theUser) {
		
		
		List<ProductCount> productCounts = productCountRepo.findProducts(theCart,theUser);
		return productCounts;
	}

	public ProductCount findProduct(long productId, long theCart, long theUser) {
		
		
		ProductCount existingProductCount = productCountRepo.findProduct(productId,theCart,theUser);
		return existingProductCount;
	}

	public long findPCid(long exitingProductId) {
		
		long productCountId = productCountRepo.findPCid(exitingProductId);
		
		return productCountId;
	}

	public void updateProductCount(int count, double offerPrice, double totalPrice, long productCountId) {
	
		productCountRepo.updateProductCount(count,offerPrice,totalPrice,productCountId);
	}

	public void save(long productId, int count, Cart cart, User user, double offerPrice, double totalPrice) {
		// TODO Auto-generated method stub
		productCountRepo.save(new ProductCount(productId,count,cart,user,offerPrice,totalPrice));
	}
	
	//productCountRepo.save()
	
}

package com.salambasha.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.ProductCount;
import com.salambasha.medicare.entities.User;
import com.salambasha.medicare.services.ProductCountService;

@Controller
@RequestMapping("/productCount")
public class ProductCountController {

	
	@Autowired
	ProductCountService productCountService;
	
	//productCountService.save(productCount);
	@GetMapping("/save")
	public String saveProductCount(@RequestParam("productId") long productId,@RequestParam("productCount") int count) {
		
		productCountService.save(productId,count);
		return "pages/productCount";
	}
	
	
	public String saveProductCount(ProductCount productCount)
	{
		productCountService.save(productCount);
		
		return null;
	}


	public void saveProductCount(long productId, int count, Cart cart, User user) {
		// TODO Auto-generated method stub
		productCountService.save(productId,count,cart,user);
	}


	public List<ProductCount> findProducts(long theCart, long theUser) {
		
		List<ProductCount> productCounts = productCountService.findProducts(theCart,theUser);
		return productCounts;
	}


	public ProductCount findProduct(long productId) {
		
	ProductCount existingProductCount = productCountService.findProduct(productId);
	
	return existingProductCount;
		
	}


	public long findPCid(long exitingProductId) {
				
		long productCountId = productCountService.findPCid(exitingProductId);
		
		return productCountId;
	}


	public void updateProductCount(int count, long productCountId) {
		
		productCountService.updateProductCount(count,productCountId);
	}
}

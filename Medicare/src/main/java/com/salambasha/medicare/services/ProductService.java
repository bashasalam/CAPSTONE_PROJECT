package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.ProductRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository prorepo;

	public boolean addProduct(String productName, String brandName, String description, double price,
			Category theCategory, String image) {
		
if(prorepo.save(new Product(productName,brandName, description, price,theCategory,image)) != null) {
			
			return true;
		}else {
			
			return false;
		}
	
		
	}

	
	

}

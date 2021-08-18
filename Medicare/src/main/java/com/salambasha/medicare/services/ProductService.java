package com.salambasha.medicare.services;

import java.util.List;

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
			Category theCategory, int quantity, String image) {
		
if(prorepo.save(new Product(productName,brandName, description, price,theCategory,quantity,image)) != null) {
			
			return true;
		}else {
			
			return false;
		}
	
		
	}

	public Product findByid(long editId) {
	
		Product product = prorepo.findById(editId);
		return product;
	}

	public void updateProduct(String productName, String brandName, String description, double price,
			Category theCategory, int quantity, String image,long productId) {
prorepo.updateProduct(productName,brandName, description, price,theCategory,quantity,image,productId);
			
		
	}

	public void disableProduct(int value,long productId) {
		prorepo.disableProduct(value,productId);
		
	}

	public List<Product> findDisabledProducts(int value) {
		
		List<Product> disabledProducts = prorepo.findDisabledProducts(value);
		System.out.println(value);
		return disabledProducts;
	}

	public List<Product> findEnabledProducts(int enableValue) {
	
		List<Product> enabledProducts = prorepo.findEnabledProducts(enableValue);
		//System.out.println(value);
		return enabledProducts;
	}

	public void enableProduct(int enableValue, long productId) {
		prorepo.enableProduct(enableValue,productId);
		
	}

//	public void deleteProduct(long productId) {
//		// TODO Auto-generated method stub
//		
//		prorepo.deleteById(productId);
//		
//		}

	
	

}

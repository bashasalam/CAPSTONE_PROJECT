package com.salambasha.medicare;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.dao.ProductRepository;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductRepositoryIntegrationTest {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	CategoryRepository cateRepo;
	
	@Test
	public void ifNewCategoryAdded_thenSuccess() {
		
		Category category = cateRepo.findById(276);
		
		Product product = new Product("productName","brandName","description",121,5,123,category,100,"image","image1","image2","image3");
		
		productRepo.save(product);
		
		assertEquals(16,productRepo.findAll().size()); 
		
	}
	
	
	
}

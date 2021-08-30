package com.salambasha.medicare;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.entities.Category;

@SpringBootTest
@RunWith(SpringRunner.class)
class MedicareApplicationTests {
	@Autowired
	CategoryRepository cateRepo;

	@Test
public void ifNewCategoryAdded_thenSuccess() {
		
		Category category = new Category("Test Category");
		
		cateRepo.save(category);
		
		assertEquals(9,cateRepo.findAll().size()); 
		
	}

}

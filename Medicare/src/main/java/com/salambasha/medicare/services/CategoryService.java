package com.salambasha.medicare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.CategoryRepository;
import com.salambasha.medicare.entities.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository cateRepo;

//	public void deleteCategory(long categoryId) {
//		// TODO Auto-generated method stub
//		cateRepo.deleteById(categoryId);
//		
//	}

	public Category findByid(long editId) {
		
		Category category = cateRepo.findById(editId);
		
		return category;
	}

	public void updateCategory( String categoryName,long categoryId) {
		// TODO Auto-generated method stub
		cateRepo.updateCategory(categoryName,categoryId);
	}
	
	public List<Category> findEngagedCategories(List<Long> categoryIdlist) {
		
		List<Category> engagedCategoryList = cateRepo.findEngagedCategories(categoryIdlist);
		
		return engagedCategoryList;
	}

	
	

}

package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salambasha.medicare.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	@Override
	List<Category> findAll();

	@Query(nativeQuery = true, value="SELECT * FROM category WHERE category_id=?1")
	public Category findById(long category_id);
    
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE category  SET category_name = ? WHERE category_id = ?")
	void updateCategory(String categoryName,long categoryId);
		
	
	
	@Query(nativeQuery = true, value="SELECT * FROM category WHERE category_id IN (:categoryIdlist)")
	List<Category> findEngagedCategories(List<Long> categoryIdlist);
	

}

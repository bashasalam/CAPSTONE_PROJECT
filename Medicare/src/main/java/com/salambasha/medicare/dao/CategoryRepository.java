package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	@Override
	List<Category> findAll();

}

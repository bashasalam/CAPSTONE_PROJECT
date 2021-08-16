package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Override
	List<Product> findAll();
	
}

package com.salambasha.medicare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.ProductCount;

@Repository
public interface ProductCountRepository extends CrudRepository<ProductCount, Long> {

	
}

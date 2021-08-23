package com.salambasha.medicare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

}

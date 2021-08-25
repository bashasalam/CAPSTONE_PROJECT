package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salambasha.medicare.entities.ProductCount;

@Repository
public interface ProductCountRepository extends CrudRepository<ProductCount, Long> {

	@Query(nativeQuery = true, value="SELECT * FROM product_count WHERE cart_id=?1 AND user_id=?2")
	List<ProductCount> findProducts(long theCart, long theUser);

	@Query(nativeQuery = true, value="SELECT * FROM product_count WHERE product_id=?")
	ProductCount findProduct(long productId);

	@Query(nativeQuery = true, value="SELECT count_table_id FROM product_count WHERE product_id=?")
	long findPCid(long exitingProductId);

	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE `product_count` SET `count` = ? WHERE `count_table_id` = ?;")
	void updateProductCount(int count, long productCountId);

	
}

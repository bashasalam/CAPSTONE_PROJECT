package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Override
	List<Product> findAll();
	
	@Query(nativeQuery = true, value="SELECT * FROM product WHERE product_id=?1")
	public Product findById(long product_id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE `product` SET `product_name` = ?,  `brand_name` = ?,`description` = ?, `price` = ?, `category_id` = ?, `quantity` =?, `image` = ?,`extra_image1` = ?,`extra_image2` = ?,`extra_image3` = ? WHERE `product_id` = ?;")
	 void updateProduct(String productName, String brandName, String description, double price, Category theCategory,
			int quantity, String image, String image1, String image2, String image3, long productId);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE `product` SET `is_active` = ? WHERE `product_id` = ?;")
	void disableProduct(int value,long productId);

	@Query(nativeQuery = true, value="SELECT * FROM product WHERE is_active=?1")
	List<Product> findDisabledProducts(int is_active);

	@Query(nativeQuery = true, value="SELECT * FROM product WHERE is_active=?1")
	List<Product> findEnabledProducts(int is_active);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE `product` SET `is_active` = ? WHERE `product_id` = ?;")
	void enableProduct(int enableValue, long productId);

	//List<Product> findEnabledProducts(int enableValue); 
	
}


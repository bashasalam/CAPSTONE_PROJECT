package com.salambasha.medicare.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.Category;
import com.salambasha.medicare.entities.User;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

	@Query(nativeQuery = true, value="SELECT * FROM cart WHERE user_id=?1 AND is_active=?2")
	List<Cart> findCart(User user, int isActive);

	@Query(nativeQuery = true, value="SELECT * FROM cart WHERE cart_id=?")
	Cart findByid(long theCart);
	
	@Query(nativeQuery = true, value="SELECT * FROM cart WHERE user_id=?1 AND is_active=?2")
	Cart findSingleCart(User user, int isActive);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="UPDATE `cart` SET `is_active` = ? WHERE `cart_id`=?;")
	void changeIsActive(int isActive,long availableCartId);
	
	

}

package com.salambasha.medicare.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.Cart;
import com.salambasha.medicare.entities.User;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {

	@Query(nativeQuery = true, value="SELECT * FROM cart WHERE user_id=?1 AND is_active=?2")
	Cart findCart(User user, int isActive);

	@Query(nativeQuery = true, value="SELECT * FROM cart WHERE cart_id=?")
	Cart findByid(long theCart);

}

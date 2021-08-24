package com.salambasha.medicare.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value="SELECT * FROM user WHERE email=?1 AND password=?2")
	User loginCheck(String email, String password);

	@Query(nativeQuery = true, value="SELECT * FROM user WHERE user_id=?")
	User findByid(long userId);

	
	
}

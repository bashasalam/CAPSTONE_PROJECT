package com.salambasha.medicare.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.salambasha.medicare.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	
	@Query(nativeQuery = true, value="SELECT * FROM admin WHERE user_name=?1 and password=?2")
	Admin loginCheck(String username, String password);

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "UPDATE `admin` SET `password` = ? WHERE  `admin_id` = ?")
	void changePassword(String newPassword,int admin_id);

	 
}

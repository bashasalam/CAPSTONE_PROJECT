package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.UserRepository;
import com.salambasha.medicare.entities.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public void save(User user) {
	
		userRepo.save(user);
		
	}

	public User loginCheck(String email, String password) {
		
		User user = userRepo.loginCheck(email,password);
		
		return user;
	}

	public User findById(long userId) {
		
		User user = userRepo.findByid(userId);
		
				return user;
	}
	

}

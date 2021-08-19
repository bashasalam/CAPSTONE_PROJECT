package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.AdminRepository;
import com.salambasha.medicare.entities.Admin;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	public Admin loginCheck(String username, String password) {
		
		
		Admin admin = adminRepo.loginCheck(username,password);
		
		return admin;
	}

	

	public void changePassword(String newPassword, int admin_id) {
		// TODO Auto-generated method stub
		adminRepo.changePassword(newPassword,admin_id);
		
	}

	
}

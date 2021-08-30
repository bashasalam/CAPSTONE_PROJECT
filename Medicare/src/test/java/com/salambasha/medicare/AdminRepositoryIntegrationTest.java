package com.salambasha.medicare;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.salambasha.medicare.dao.AdminRepository;
import com.salambasha.medicare.entities.Admin;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminRepositoryIntegrationTest {
	
	@Autowired
	AdminRepository AdminRepo;
	
	@Test
	public void ifNewAdminAdded_thenSuccess() {
		
		Admin Admin = new Admin("testPassword","TestAdmin");
		
		AdminRepo.save(Admin);
		
	//	assertEquals(11,AdminRepo.findAll()); 
		
	}

}

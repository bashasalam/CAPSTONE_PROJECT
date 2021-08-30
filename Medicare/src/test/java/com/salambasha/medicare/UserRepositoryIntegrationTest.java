package com.salambasha.medicare;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.salambasha.medicare.dao.UserRepository;
import com.salambasha.medicare.entities.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryIntegrationTest {
	
	@Autowired
	UserRepository userRepo;
	
	@Test
	public void ifNewUserAdded_thenSuccess() {
		
		User user = new User("Testuser","testuser@gmail.com",979884544,"test");
		
		userRepo.save(user);
		
	//	assertEquals(11,userRepo.findAll()); 
		
	}

}

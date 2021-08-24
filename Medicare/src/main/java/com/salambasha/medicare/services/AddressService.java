package com.salambasha.medicare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salambasha.medicare.dao.AddressRepository;
import com.salambasha.medicare.entities.Address;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepo;
	
	public void save(Address address) {

		addressRepo.save(address);
		
	}

	
}

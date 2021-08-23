package com.salambasha.medicare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}

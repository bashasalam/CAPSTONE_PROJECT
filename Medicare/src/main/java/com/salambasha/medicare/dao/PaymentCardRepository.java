package com.salambasha.medicare.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salambasha.medicare.entities.PaymentCard;

@Repository
public interface PaymentCardRepository extends CrudRepository<PaymentCard, Long> {

}

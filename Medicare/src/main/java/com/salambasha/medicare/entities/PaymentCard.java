package com.salambasha.medicare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long paymentCardId;
	private String nameOnCard;
	private long cardNumber;
	
	private String validThrough;
	private int csvNumber;
	public PaymentCard() {
		super();
	}
	public PaymentCard(String nameOnCard, long cardNumber, String validThrough, int csvNumber) {
		super();
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.validThrough = validThrough;
		this.csvNumber = csvNumber;
	}
	public long getPaymentCardId() {
		return paymentCardId;
	}
	public void setPaymentCardId(long paymentCardId) {
		this.paymentCardId = paymentCardId;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getValidThrough() {
		return validThrough;
	}
	public void setValidThrough(String validThrough) {
		this.validThrough = validThrough;
	}
	public int getCsvNumber() {
		return csvNumber;
	}
	public void setCsvNumber(int csvNumber) {
		this.csvNumber = csvNumber;
	}
	
	
	
	

}

package com.salambasha.medicare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductCount {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long countTableId;
	private long productId;
	private int count;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="cart_id")
	private Cart theCart;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User theUser;
	
	
	
	 
	public ProductCount() {
		super();
	}


	public ProductCount(long productId, int count) {
		super();
		this.productId = productId;
		this.count = count;
	}

	
	

	public ProductCount(long productId, int count, Cart theCart, User theUser) {
		super();
		this.productId = productId;
		this.count = count;
		this.theCart = theCart;
		this.theUser = theUser;
	}


	public Cart getTheCart() {
		return theCart;
	}


	public void setTheCart(Cart theCart) {
		this.theCart = theCart;
	}


	public User getTheUser() {
		return theUser;
	}


	public void setTheUser(User theUser) {
		this.theUser = theUser;
	}


	public long getCountTableId() {
		return countTableId;
	}


	public void setCountTableId(long countTableId) {
		this.countTableId = countTableId;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	@Override
	public String toString() {
		return "ProductCount [countTableId=" + countTableId + ", productId=" + productId + ", count=" + count + "]";
	}
	
	

	
	
	
	
	
}

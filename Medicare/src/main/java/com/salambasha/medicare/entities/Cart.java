package com.salambasha.medicare.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
    
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long cartId;
	@OneToMany(mappedBy="theCart")
	private List<ProductCount> productCounts;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
//	@OneToMany(mappedBy="")
//	private List<Product> products;
	
	private int isActive=1;
	
	public Cart() {
		super();
	}

	public Cart(List<ProductCount> productCounts, User user, int isActive) {
		super();
		this.productCounts = productCounts;
		//this.user = user;
		this.isActive = isActive;
	}
	
	

	public Cart(User user, int isActive) {
		super();
		this.user = user;
		this.isActive = isActive;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public List<ProductCount> getProductCounts() {
		return productCounts;
	}

	public void setProductCounts(List<ProductCount> productCounts) {
		this.productCounts = productCounts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
	
	
	
	
}

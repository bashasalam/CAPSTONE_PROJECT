package com.salambasha.medicare.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;
	private String fullName;
	private String email;
	private long mobile;
	private String password;
	
//	@OneToOne(mappedBy="theUser", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,
//			CascadeType.REFRESH},fetch = FetchType.LAZY, orphanRemoval = true)
//	//@JoinColumn(name = "cart_id")
//	private Cart cart;
	
	@OneToMany(mappedBy="theUser")
	private List<Cart> carts;
	
	@OneToMany(mappedBy="theUser")
	private List<Address> address;
	
	@OneToMany(mappedBy="theUser")
	private List<ProductCount> productCount;
	
	
	//private Address address;
	//private Cart theCart;
	public User() {
		super();
	}
	
	
	
	public User(String fullName, String email, long mobile, String password) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	


	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(List<Address> address) {
		this.address = address;
	}



	public List<ProductCount> getProductCount() {
		return productCount;
	}



	public void setProductCount(List<ProductCount> productCount) {
		this.productCount = productCount;
	}



	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public List<Cart> getCarts() {
		return carts;
	}



	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}



	

	
	
	
	

}

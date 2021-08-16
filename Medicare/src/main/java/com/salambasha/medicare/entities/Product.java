package com.salambasha.medicare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long productId;
	private String productName;
	private String brandName;
	private String description;
	private double price;
	private int quantity;
	private String image;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
	private Category theCategory;
	
	
	
	
	
	public Category getTheCategory() {
		return theCategory;
	}
	public void setTheCategory(Category theCategory) {
		this.theCategory = theCategory;
	}
	public Product() {
		super();
	}
	public Product(String productName, String brandName, String description, double price,
			Category theCategory, int quantity, String image) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.description = description;
		this.price = price;
		this.theCategory = theCategory;
		this.quantity = quantity;
		this.image = image;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", description=" + description + ", price=" + price + ", image=" + image + ", theCategory="
				+ theCategory + "]";
	}
	
	
	
	

}

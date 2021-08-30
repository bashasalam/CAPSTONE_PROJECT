package com.salambasha.medicare.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private double offer; 
	private double offerPrice;
//	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
//			CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
//	@JoinColumn(name="category_id")
//	private Category theCategory;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category theCategory;
	private int quantity;
	private String image;
	private String extraImage1;
	private String extraImage2;
	private String extraImage3;
	@Column(name="is_active")
	private int isActive = 1;
	
	
	 
	
	public Product() {
		super();
	}


	public Product(String productName, String brandName, String description, double price, double offer,
			double offerPrice, Category theCategory, int quantity, String image, String extraImage1, String extraImage2,
			String extraImage3) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.description = description;
		this.price = price;
		this.offer = offer;
		this.offerPrice = offerPrice;
		this.theCategory = theCategory;
		this.quantity = quantity;
		this.image = image;
		this.extraImage1 = extraImage1;
		this.extraImage2 = extraImage2;
		this.extraImage3 = extraImage3;
		//this.isActive = isActive;
	}
	
	
	public Category getTheCategory() {
		return theCategory;
	}
	public void setTheCategory(Category theCategory) {
		this.theCategory = theCategory;
	}
	
	
		
	
	
		public Product(String productName, String brandName, String description, double price, double offer,
			double offerPrice, int quantity, String image, String extraImage1, String extraImage2, String extraImage3,
			int isActive, Category theCategory) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.description = description;
		this.price = price;
		this.offer = offer;
		this.offerPrice = offerPrice;
		this.quantity = quantity;
		this.image = image;
		this.extraImage1 = extraImage1;
		this.extraImage2 = extraImage2;
		this.extraImage3 = extraImage3;
		this.isActive = isActive;
		this.theCategory = theCategory;
	}
		public String getExtraImage1() {
		return extraImage1;
	}
	public void setExtraImage1(String extraImage1) {
		this.extraImage1 = extraImage1;
	}
	public String getExtraImage2() {
		return extraImage2;
	}
	public void setExtraImage2(String extraImage2) {
		this.extraImage2 = extraImage2;
	}
	public String getExtraImage3() {
		return extraImage3;
	}
	public void setExtraImage3(String extraImage3) {
		this.extraImage3 = extraImage3;
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
	
	
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
	public double getOffer() {
		return offer;
	}
	public void setOffer(double offer) {
		this.offer = offer;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", description=" + description + ", price=" + price + ", offer=" + offer + ", offerPrice="
				+ offerPrice + ", quantity=" + quantity + ", image=" + image + ", extraImage1=" + extraImage1
				+ ", extraImage2=" + extraImage2 + ", extraImage3=" + extraImage3 + ", isActive=" + isActive
				+ ", theCategory=" + theCategory + "]";
	}
	
	
	
	
	
	
	
	

}

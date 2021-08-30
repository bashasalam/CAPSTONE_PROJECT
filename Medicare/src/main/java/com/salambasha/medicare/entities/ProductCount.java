package com.salambasha.medicare.entities;
import java.sql.Timestamp;



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
	
	private double singleProductPrice;
	
	private double multipliedPrice;
	
	private String mainImage;
	private String madicineName;
	private String brandName;
	private Timestamp purchaseTime;
	
	
//	
//	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//	    LocalDateTime now = LocalDateTime.now();
	    
	 //  System.out.println(dtf.format(now));
	   // LocalDateTime now;
	
	
	 
	public ProductCount(long productId, int count, Cart theCart, User theUser, double singleProductPrice,
			double multipliedPrice, String mainImage, String madicineName, String brandName) {
		super();
		this.productId = productId;
		this.count = count;
		this.theCart = theCart;
		this.theUser = theUser;
		this.singleProductPrice = singleProductPrice;
		this.multipliedPrice = multipliedPrice;
		this.mainImage = mainImage;
		this.madicineName = madicineName;
		this.brandName = brandName;
	}


	public ProductCount() {
		super();
	}


	public ProductCount(long productId, int count) {
		super();
		this.productId = productId;
		this.count = count;
	}

	
	

	public ProductCount(long productId, int count, Cart theCart, User theUser, double singleProductPrice,
			double multipliedPrice) {
		super();
		this.productId = productId;
		this.count = count;
		this.theCart = theCart;
		this.theUser = theUser;
		this.singleProductPrice = singleProductPrice;
		this.multipliedPrice = multipliedPrice;
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

	

	public double getSingleProductPrice() {
		return singleProductPrice;
	}


	public void setSingleProductPrice(double singleProductPrice) {
		this.singleProductPrice = singleProductPrice;
	}


	public double getMultipliedPrice() {
		return multipliedPrice;
	}


	public void setMultipliedPrice(double multipliedPrice) {
		this.multipliedPrice = multipliedPrice;
	}


	public String getMainImage() {
		return mainImage;
	}


	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}


	public String getMadicineName() {
		return madicineName;
	}


	public void setMadicineName(String madicineName) {
		this.madicineName = madicineName;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}


	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}


	@Override
	public String toString() {
		return "ProductCount [countTableId=" + countTableId + ", productId=" + productId + ", count=" + count
				+ ", theCart=" + theCart + ", theUser=" + theUser + ", singleProductPrice=" + singleProductPrice
				+ ", multipliedPrice=" + multipliedPrice + ", mainImage=" + mainImage + ", madicineName=" + madicineName
				+ ", brandName=" + brandName + ", purchaseTime=" + purchaseTime + "]";
	}


	



	

	
	
	
	
	
}

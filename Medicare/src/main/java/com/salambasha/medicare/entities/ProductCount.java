package com.salambasha.medicare.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCount {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long countTableId;
	private long productId;
	private int count;
	
	
	public ProductCount() {
		super();
	}


	public ProductCount(long productId, int count) {
		super();
		this.productId = productId;
		this.count = count;
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

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
public class Address {
     
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long addressId;
	private int doorNo;
	private String streetName;
	//private String village;
	private String city;
	private String state;
	private long pincode;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User theUser; 
//	private User user;
	public Address() {
		super();
	}
	
	 
	
public Address(int doorNo, String streetName, String city, String state, long pincode, User theUser) {
	super();
	this.doorNo = doorNo;
	this.streetName = streetName;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.theUser = theUser;
}



public User getTheUser() {
	return theUser;
}
public void setTheUser(User theUser) {
	this.theUser = theUser;
}
public long getAddressId() {
	return addressId;
}
public void setAddressId(long addressId) {
	this.addressId = addressId;
}
public int getDoorNo() {
	return doorNo;
}
public void setDoorNo(int doorNo) {
	this.doorNo = doorNo;
}
public String getStreetName() {
	return streetName;
}
public void setStreetName(String streetName) {
	this.streetName = streetName;
}
//public String getVillage() {
//	return village;
//}
//public void setVillage(String village) {
//	this.village = village;
//}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public long getPincode() {
	return pincode;
}
public void setPincode(long pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", doorNo=" + doorNo + ", streetName=" + streetName + ", city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
}


	 
	
	
}

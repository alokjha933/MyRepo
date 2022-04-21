package com.jpa.jpaproject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customers {

	@Id
	private String customerName;
	private String contactName;
	private String address;
	private String city;
	private String postalCode;
	private String country;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Customers [customerName=" + customerName + ", contactName=" + contactName + ", address=" + address
				+ ", city=" + city + ", postalCode=" + postalCode + ", country=" + country + "]";
	}
}

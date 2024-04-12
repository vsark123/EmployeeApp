package org.jsp.employeeapp.entity;

import jakarta.persistence.Entity;
import lombok.Data;

//@Entity
//@Data
public class Address {
	
	private String houseNo;
	private String street;
	private String city;
	private String state;
	private double pincode;
	private String country;

}

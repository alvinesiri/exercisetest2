package com.exercise2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Customer {
	@JsonProperty("phoneNumber")
	public String phoneNumber;
	@JsonProperty("dateJoined")
	public Date dateJoined;
        
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Override
	public String toString() {
		return "{\"phoneNumber\":\"" + phoneNumber + "\", \"dateJoined\":\"" + dateJoined.toString() + "\"]";
	}
}

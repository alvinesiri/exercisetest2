package com.exercise2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	@JsonProperty("phoneNumber")
	public String phoneNumber;
        
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "{\"phoneNumber\":\"" + phoneNumber + "\"]";
	}
}

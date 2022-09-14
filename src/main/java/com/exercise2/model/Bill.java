package com.exercise2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bill {
	@JsonProperty("phoneNumber")
	public String phoneNumber;
	@JsonProperty("amount")
	public double amount;
	@JsonProperty("isGroceries")
	public boolean isGroceries;
        
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean getIsGroceries() {
		return isGroceries;
	}
	public void setIsGroceries(boolean isGroceries) {
		this.isGroceries = isGroceries;
	}

	@Override
	public String toString() {
		return "{\"phoneNumber\":\"" + phoneNumber
				+ "\", \"amount\":\"" + amount
				+ "\", \"isGroceries\":\"" + isGroceries + "\"]";
	}
}

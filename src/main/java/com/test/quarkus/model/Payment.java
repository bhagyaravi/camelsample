package com.test.quarkus.model;

import java.util.Date;
import java.util.UUID;

public class Payment {
	String paymentType;
	String cardnumber;
	Date expiryDate;
	int cvvnumber;
	long amount;
	String status = "inprogress";
	UUID tripId;
	
	public UUID getTripId() {
		return this.tripId;
	}

    	public void setTripId(UUID tripId) {
		this.tripId = tripId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public int getCvvnumber() {
		return cvvnumber;
	}
	public void setCvvnumber(int cvvnumber) {
		this.cvvnumber = cvvnumber;
	}
	
}

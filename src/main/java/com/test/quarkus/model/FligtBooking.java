package com.test.quarkus.model;

import java.util.UUID;

public class FligtBooking {
	
	UUID tripId;
    UUID flightId;
    long flightAmount;
    String flightClass;
    String flightBookingStatus;

   
    public UUID getTripId() {
		return this.tripId;
	}

    public void setTripId(UUID tripId) {
		this.tripId = tripId;
	}

    public UUID getFlightId() {
        return this.flightId;
    }

    public void setFlightId(UUID flightId) {
        this.flightId = flightId;
    }

    public long getFlightAmount() {
        return this.flightAmount;
    }

    public void setFlightAmount(long flightAmount) {
        this.flightAmount = flightAmount;
    }

    public String getFlightClass() {
        return this.flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
   public String getFlightBookingStatus() {
        return this.flightBookingStatus;
    }

    public void setFlightBookingStatus(String flightBookingStatus) {
        this.flightBookingStatus = flightBookingStatus;
    }

}

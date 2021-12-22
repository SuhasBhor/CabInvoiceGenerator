package com.services;

import com.entity.CabInvoiceData;
import com.entity.Ride;

public class Invoice_Generator {
	public static final double COSTPerKM = 10.0;
	public static final double COSTPerMIN = 1.0;
	public static final double MIN_FARE = 5;

	 // method to check the fare and totalFare < 5 then use the minfare data
	public double calculateFare(double distance, int time) {
		double totalFare = distance * COSTPerKM + time * COSTPerMIN;
		if (totalFare < 5) {
			return MIN_FARE;
		}
		return totalFare;
	}
	
	//method to check the multiple ride fare
	public CabInvoiceData calculateFareForMultiple_Ride(Ride[] rides) {
		double totalFare = 0;
		for(int i = 0; i < rides.length; i++) {
			Ride ride = rides[i];
			double fare = ride.getDistance() * COSTPerKM + ride.getTime() * COSTPerMIN;
			totalFare += fare;
		}
		return new CabInvoiceData(rides.length,totalFare);
	}
}

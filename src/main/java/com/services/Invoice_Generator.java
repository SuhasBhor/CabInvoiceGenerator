package com.services;

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
}

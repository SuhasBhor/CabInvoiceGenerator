package com.services;

import java.util.HashMap;
import java.util.Map;

import com.entity.CabInvoiceData;
import com.entity.Ride;

public class Invoice_Generator {
	public static final double COSTPerKM = 10.0;
	public static final double COSTPerMIN = 1.0;
	public static final double MIN_FARE = 5;

	public static final double PREMIUMCOSTPerKM = 15.0;
	public static final double PREMIUMCOSTPerMIN = 2.0;
	public static final double PREMIUMMIN_FARE = 20;

	// method to check the fare and totalFare < 5 then use the minfare data
	public double calculateFare(double distance, int time, String type) {
		if (type == "Normal") {
			double totalFare = distance * COSTPerKM + time * COSTPerMIN;
			if (totalFare < 5) {
				return MIN_FARE;
			}
			return totalFare;
		} else {
			double totalFare = distance * PREMIUMCOSTPerKM + time * PREMIUMCOSTPerMIN;
			if (totalFare < 20) {
				return PREMIUMMIN_FARE;
			}
			return totalFare;
		}
	}

	// method to check the multiple ride fare
	public CabInvoiceData calculateFareForMultiple_Ride(Ride[] rides, String type) {
		if (type == "Normal") {
			double totalFare = 0;
			for (int i = 0; i < rides.length; i++) {
				Ride ride = rides[i];
				double fare = ride.getDistance() * COSTPerKM + ride.getTime() * COSTPerMIN;
				totalFare += fare;
			}
			return new CabInvoiceData(rides.length, totalFare);
		} else {
			double totalFare = 0;
			for (int i = 0; i < rides.length; i++) {
				Ride ride = rides[i];
				double fare = ride.getDistance() * PREMIUMCOSTPerKM + ride.getTime() * PREMIUMCOSTPerMIN;
				totalFare += fare;
			}
			return new CabInvoiceData(rides.length, totalFare);
		}
	}
	
	//Calculate Fare for Total Daily Rides Of One User
	public CabInvoiceData cabSummaryCalculate(int userId, String type) {
		if (type == "Normal") {
			Map<Integer, Ride[]> map = new HashMap<>();
			Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
			Ride[] rides1 = { new Ride(2.0, 5), new Ride(1.0, 1) };
			map.put(3, rides);
			map.put(1, rides1);
			for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
				if (userId == entry.getKey()) {
					Ride[] data = entry.getValue();
					return calculateFareForMultiple_Ride(data, type);
				}
			}
			return null;
		} else {
			Map<Integer, Ride[]> map = new HashMap<>();
			Ride[] rides = { new Ride(2.0, 5), new Ride(1.0, 1) };
			Ride[] rides1 = { new Ride(2.0, 5), new Ride(0.1, 1) };
			map.put(3, rides);
			map.put(1, rides1);
			for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
				if (userId == entry.getKey()) {
					Ride[] data = entry.getValue();
					return calculateFareForMultiple_Ride(data, type);
				}
			}
			return null;
		}
	}
}

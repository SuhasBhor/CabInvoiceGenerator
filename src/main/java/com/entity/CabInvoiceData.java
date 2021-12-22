package com.entity;

import java.util.Objects;

public class CabInvoiceData {
	//Initialize CabInvoiceData Class Variable
	int totalNumberOfRide;
	double totalFare;
	double avgFarePerRide;
	
	//Constructor
	public CabInvoiceData(int totalNumberOfRide, double totalFare) {
		this.totalNumberOfRide = totalNumberOfRide;
		this.totalFare = totalFare;
		this.avgFarePerRide = this.totalFare /this.totalNumberOfRide;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CabInvoiceData other = (CabInvoiceData) obj;
		return totalNumberOfRide == other.totalNumberOfRide && Double.compare(other.totalFare, totalFare) == 0 && Double.compare(other.avgFarePerRide, avgFarePerRide) == 0;
	}
	
}

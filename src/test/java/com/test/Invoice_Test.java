package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.entity.CabInvoiceData;
import com.entity.Ride;
import com.services.Invoice_Generator;

public class Invoice_Test {
	Invoice_Generator invoiceGenerator = new Invoice_Generator();

	// test method to check the fare return through the method data
	@Test
	public void givenDistanceAndTime_ShouldReturnFare() {
		double distance = 2.0;
		int time = 5;
		String type = "Normal";
		double result = invoiceGenerator.calculateFare(distance, time, type);
		assertEquals(25, result, 0.0);
	}

	// test method to check the fare return through the method data For Premium Data
	@Test
	public void givenDistanceAndTime_PremiumData_ShouldReturnFare() {
		double distance = 2.0;
		int time = 5;
		String type = "Premium";
		double result = invoiceGenerator.calculateFare(distance, time, type);
		assertEquals(40, result, 0.0);
	}

	// test method check the minfare data
	@Test
	public void givenDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		String type = "Normal";
		double result = invoiceGenerator.calculateFare(distance, time, type);
		assertEquals(5.0, result, 0.0);
	}

	// test method check the minfare data for Premium Data
	@Test
	public void givenDistanceAndTime_PremiumData_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		String type = "Premium";
		double result = invoiceGenerator.calculateFare(distance, time, type);
		assertEquals(20.0, result, 0.0);
	}

	// test method check the multiple ride data
	@Test
	public void givenMultipleRide_ShouldReturnFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		String type = "Normal";
		CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides, type);
		CabInvoiceData expectedData = new CabInvoiceData(2, 27.0);
		assertEquals(result, expectedData);
	}

	@Test
	public void givenMultipleRide_PremiumData_ShouldReturnFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(1.0, 1) };
		String type = "Premium";
		CabInvoiceData result = invoiceGenerator.calculateFareForMultiple_Ride(rides, type);
		CabInvoiceData expectedData = new CabInvoiceData(2, 57.0);
		assertEquals(result, expectedData);
	}

	@Test
	public void givenUserID_ShouldReturnInvoiceData() {
		String type = "Normal";
		CabInvoiceData cabInvoiceData = invoiceGenerator.cabSummaryCalculate(3, type);
		CabInvoiceData expectedResult = new CabInvoiceData(2, 27.0);
		assertEquals(cabInvoiceData.getInvoiceData(), expectedResult.getInvoiceData());
	}

	@Test
	public void givenUserID_PremiumData_ShouldReturnInvoiceData() {
		String type = "Premium";
		CabInvoiceData cabInvoiceData = invoiceGenerator.cabSummaryCalculate(3, type);
		CabInvoiceData expectedResult = new CabInvoiceData(2, 57.0);
		assertEquals(cabInvoiceData.getInvoiceData(), expectedResult.getInvoiceData());
	}
}

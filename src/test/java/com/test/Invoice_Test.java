package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.entity.Ride;
import com.services.Invoice_Generator;

public class Invoice_Test {
	Invoice_Generator invoiceGenerator = new Invoice_Generator();
	
	// test method to check the fare return through the method data
    @Test
    public void givenDistanceAndTime_ShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = invoiceGenerator.calculateFare(distance,time);
        assertEquals(25,result,0.0);
    }
    
    // test method check the minfare data
    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double result = invoiceGenerator.calculateFare(distance,time);
        assertEquals(5.0,result,0.0);
    }
    
    //test method check the multiple ride data
    @Test
    public void givenMultipleRide_ShouldReturnFare() {
    	Ride[] rides = {
    		new Ride(2.0,5),
    		new Ride(0.1,1)
    	};
    	double result = invoiceGenerator.calculateFareForMultiple_Ride(rides);
        assertEquals(27.0,result,0.0);
    }
}

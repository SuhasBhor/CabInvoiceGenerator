package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.services.Invoice_Generator;

public class Invoice_Test {
	Invoice_Generator invoiceGenerator = new Invoice_Generator();
	
	// test method to check the fare return through the method data
    @Test
    public void GivenDistanceAndTime_ShouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = invoiceGenerator.calculateFare(distance,time);
        assertEquals(25,result,0.0);
    }
    
    // test method check the minfare data
    @Test
    public void GivenDistanceAndTime_ShouldReturnMinFare(){
        double distance = 0.1;
        int time = 1;
        double result = invoiceGenerator.calculateFare(distance,time);
        assertEquals(5.0,result,0.0);
    }
}

package com.entity;

public class Ride {
	//Initialize Ride class Variable
	double distance;
	int time;
	
	//Constructor
	public Ride(double distance, int time) {
		this.distance = distance;
		this.time = time;
	}
	
	//Getter of Variable
	public double getDistance() {
		return distance;
	}

	public int getTime() {
		return time;
	}
}

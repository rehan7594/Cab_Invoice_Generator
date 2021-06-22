package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class CabService {
	double totalfare=0;
	double totalFareForMultipleRides;
	double averagefarePerRide;

	private static final double MIN_COST_PER_KM=10;
	private static final int MIN_COST_PER_MINUTE=1;
	private static final int MIN_FARE=5;

	public double calculateFare(final double distance, final int minute) {

		totalfare=(distance*MIN_COST_PER_KM) + minute;

		if(totalfare==0.0) {
			return totalfare=0;			
		}

		if(totalfare<5.0 ) {
			return totalfare=5;
		}

		return totalfare;
	}

	public double calculateFare(Ride[] rides) {
		for(Ride ride:rides) {
			totalfare+=this.calculateFare(ride.distance, ride.minute);
		}
		return totalfare;
	}

	public InvoiceSummary calculateTotalFare(Ride[] ride) {
		double totalfare = 0;
		double averageFare = 0;
		for(Ride rides: ride) {
			totalfare += this.calculateFare(rides.distance, rides.minute);	
		}
		averageFare = totalfare/ride.length;
		return new InvoiceSummary(ride.length, totalfare, averageFare);
	}

	public double calculateFare(String choice, double distance, int minute) {
		if(choice.equalsIgnoreCase("Normal")) {
			int costPerMinute =1;
			double minCostPerKm =10;
			double minfare = 5;
			totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}else if(choice.equalsIgnoreCase("Premium")) {
			int costPerMinute =2;
			double minCostPerKm =15;
			double minfare = 20;
			double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}

		//double totalfare = (distance * MIN_COST_PER_KM) + (minute * MIN_COST_PER_MINUTE);
		return 0;
	}
}
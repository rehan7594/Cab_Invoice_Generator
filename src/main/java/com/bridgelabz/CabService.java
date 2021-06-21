package com.bridgelabz;

public class CabService {
	double totalfare=0;
	double totalFareForMultipleRides;
	double averagefarePerRide;

	public double calculateFare(final double distance, final int minute) {

		totalfare=(distance*10) + minute;

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
}
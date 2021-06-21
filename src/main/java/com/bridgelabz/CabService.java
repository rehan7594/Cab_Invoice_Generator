package com.bridgelabz;

public class CabService {
	double totalfare=0;

	public double calculateFare(final double distance, final int minute) {


		if(distance==0.0 && minute==0) {
			return totalfare=0;			
		}

		if(distance < 1.0 && minute<=5 ) {
			return totalfare=5;
		}
		totalfare=(distance*10) + minute;
		return totalfare;
	}

	public double totalFareForMultipleRide(final double totalFare2, final int numOfRides) {

		double totalFareForMultipleRides = totalFare2 * numOfRides;
		return totalFareForMultipleRides;

	}
}
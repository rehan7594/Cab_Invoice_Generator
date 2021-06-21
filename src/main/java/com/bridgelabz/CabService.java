package com.bridgelabz;

public class CabService {
	public double calculateFare(final double distance, final int minute) {
		double totalfare=0;

		if(distance==0.0 && minute==0) {
			return totalfare=0;			
		}

		if(distance < 1.0 && minute<=5 ) {
			return totalfare=5;
		}
		totalfare=(distance*10) + minute;
		return totalfare;
	}
}
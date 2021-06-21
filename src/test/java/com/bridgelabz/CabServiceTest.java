package com.bridgelabz;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CabServiceTest {
	CabService cabService = new CabService();

	@Test
	public void testCalculateFare_Should_Return_Total_Fare() {

		final double distance =260;
		final int minute=90;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(2690, totalFare,0);
	}

	@Test
	public void testCalculateFare_Should_Return_Min_Fare() {

		final double distance =0.1;
		final int minute=1;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(5, totalFare,0);
	}

	@Test
	public void testCalculateFare_Should_Return_Zero_Fare() {	
		final double distance =0.0;
		final int minute=0;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(0, totalFare,0);
	}

	@Test
	public void testCalculateTotalFare_Should_ReturnTotalFare_forMultipleRides() {	

		Ride [] rides= {new Ride(2.0,5),
				new Ride(0.1,1)
		};
		double Fare=cabService.calculateFare(rides);
		assertEquals(30.0, Fare , 0);
	}

	@Test
	public void test_shouldReturn_TotalFare_averageFarePerRide_and_numOfRides() {	
		Ride [] rides= {new Ride(2.0,5),
				new Ride(0.1,1)
		};

		InvoiceSummary invoiceSummary = cabService.calculateTotalFare(rides);
		InvoiceSummary expected = new InvoiceSummary(2, 30, 15);
		assertEquals(expected, invoiceSummary);	
	}	
}
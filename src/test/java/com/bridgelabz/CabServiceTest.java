package com.bridgelabz;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CabServiceTest {
	@Test
	public void testCalculateFare_Should_Return_Total_Fare() {

		CabService cabService = new CabService();

		final double distance =260;
		final int minute=90;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(2690, totalFare,0);
	}

	@Test
	public void testCalculateFare_Should_Return_Min_Fare() {

		CabService cabService = new CabService();

		final double distance =0.5;
		final int minute=5;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(5, totalFare,0);
	}

	@Test
	public void testCalculateFare_Should_Return_Zero_Fare() {

		CabService cabService = new CabService();

		final double distance =0.0;
		final int minute=0;
		double totalFare=cabService.calculateFare(distance,minute);
		assertEquals(0, totalFare,0);
	}
}

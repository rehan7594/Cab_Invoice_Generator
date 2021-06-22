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
	public void testCalculateTotalFare_Should_ReturnZero_TotalFare_forMultipleRides() {	

		Ride [] rides= {new Ride(0.0,0),
				new Ride(0,0)
		};
		double Fare=cabService.calculateFare(rides);
		assertEquals(0.0, Fare , 0);
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

	@Test
	public void given_NormalChoice_shouldReturn_TotalFare() {
		String choice = "Normal";
		double distance = 22.0;
		int minute = 10;
		double fare = cabService.calculateFare(choice,distance, minute);
		assertEquals(230.0, fare,  0.0);

	}

	@Test
	public void given_NormalChoice_should_Return_TotalFare() {
		String choice = "Normal";
		double distance = -22.0;
		int minute = -10;
		double fare = cabService.calculateFare(choice,distance, minute);
		assertEquals(-230.0, fare,  0.0);

	}

	@Test
	public void given_WrongChoice_shouldReturn_null() {
		String choice = "Middle";
		Double distance = 22.0;
		int minute = 10;
		double fare = cabService.calculateFare(choice,distance, minute);
		assertEquals("Middle is not option", fare, 0.0,0);

	}

	@Test
	public void given_PremiumChoice_shouldReturn_TotalFare_ForGivenChoice() {
		String choice = "Premium";
		double distance = 11.0;
		int minute = 7;
		double fare = cabService.calculateFare(choice,distance, minute);
		assertEquals(179.0, fare,  0.0);

	}

	@Test
	public void givenUserId_shouldReturn_InvoiceSummary() throws InvalidInputException {
		String user ="U1";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("U1",3,363,121);
		assertEquals(expected, invoicerecords);	
	}

	@Test
	public void givenUserId_shouldreturn_InvoiceSummary() throws InvalidInputException {
		String user ="U3";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		InvoiceRecords expected = new InvoiceRecords("U3",4,208,52);
		assertEquals(expected, invoicerecords);	
	}

	@Test
	public void givenUserId_shouldReturn_InvalidInputException() throws InvalidInputException {
		String user =" ";
		InvoiceRecords invoicerecords = cabService.findInvoice(user);
		assertEquals(null, invoicerecords);	
	}
}
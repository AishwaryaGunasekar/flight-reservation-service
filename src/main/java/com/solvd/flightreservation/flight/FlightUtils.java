package com.solvd.flightreservation.flight;

public class FlightUtils {

	public static final double TAX_RATE = 0.7;

	public static double calculateTotalFare(double baseFare) {
		double tax = baseFare * TAX_RATE;
		return baseFare + tax;
	}
}

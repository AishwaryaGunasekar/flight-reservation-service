package com.solvd.flightreservation.constants;

import java.util.Arrays;
import java.util.List;

public interface CommonConstants {

	List<String> ECONOMY_SERVICES = Arrays.asList("In-flight entertainment", "Complimentary meals");
	List<String> BUSINESS_SERVICES = Arrays.asList("In-flight ", "Complimentary meals");

	public static final int MAX_FLIGHT_CAPACITY = 100;
	public static final int FLIGHT_BASE_FARE= 1000;
	public static final int CONVIENCE_FEE = 1000;
	public static final int EXTRA_BAGGAGE_CHARGES =250;
	public static final int TAX= 1000;
}

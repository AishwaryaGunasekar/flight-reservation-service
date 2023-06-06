
package com.solvd.flightreservation.interfaces;

import com.solvd.flightreservation.flight.Flight;

public interface Calculateprice {
	
	double calculateTicketPrice();

	double calculateTotalCost( int numOfPassengers);
}

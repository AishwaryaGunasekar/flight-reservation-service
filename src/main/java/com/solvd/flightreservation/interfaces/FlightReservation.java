package com.solvd.flightreservation.interfaces;

import com.solvd.flightreservation.flight.FlightDetails;

public interface FlightReservation {

	void reserveSeat();

	void displayReservationDetails();

	void showSeatType();

	boolean checkAvailability(FlightDetails flightd, int numOfPassengers);

	boolean reserveFlight(FlightDetails flightd, int numOfPassengers);
}

package com.solvd.flightreservation.type;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.exceptions.UnavailableSeatException;
import com.solvd.flightreservation.flight.Flight;
import com.solvd.flightreservation.flight.FlightDetails;
import com.solvd.flightreservation.interfaces.Calculateprice;
import com.solvd.flightreservation.interfaces.FlightReservation;
import com.solvd.flightreservation.interfaces.SeatType;

public class BusinessClassReservation implements FlightReservation, Calculateprice, SeatType {

	private static final Logger LOGGER = LogManager.getLogger(BusinessClassReservation.class);
	private Flight flight;
	private int reservationNumber;

	private Map<String, Flight> flights;

	public BusinessClassReservation() {
	}

	public BusinessClassReservation(Flight flight, int reservationNumber) {
		this.flight = flight;
		this.reservationNumber = reservationNumber;
	}

	@Override
	public void reserveSeat() {
		if (flight.checkAvailability()) {
			flight.bookSeat();
			LOGGER.info("Seat booked successfully!");
		} else {

			LOGGER.error("Sorry, no seats available on this flight.");
			throw new UnavailableSeatException("Unavailabilty of seat  ");
		}
	}

	@Override
	public void displayReservationDetails() {
		LOGGER.info("Reservation Number: " + reservationNumber);
			}

	@Override
	public double calculateTicketPrice() {
		return flight.getFare() * 1.2;
	}

	public void showSeatType() {
		LOGGER.info("Business Class is with Window seat");
	}

	@Override
	public double calculateTotalCost( int numOfPassengers) {
		Flight storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null) {
			return storedFlight.getPrice(numOfPassengers);
		}
		return 0.0;
	}

	@Override
	public boolean checkAvailability(FlightDetails flightd, int numOfPassengers) {
		// TODO Auto-generated method stub
		Flight storedFlight = flights.get(flight.getFlightNumber());
		return storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers);
	}

	@Override
	public boolean reserveFlight(FlightDetails flightd, int numOfPassengers) {
		// TODO Auto-generated method stub
		Flight storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers)) {
			storedFlight.reserveSeats(numOfPassengers);
			return true;
		}
		return false;
	}


}

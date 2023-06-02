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

public abstract class BusinessClassReservation implements FlightReservation, Calculateprice, SeatType {

	private static final Logger LOGGER = LogManager.getLogger(BusinessClassReservation.class);
	private Flight flight;
	private int reservationNumber;

	private Map<String, FlightDetails> flights;

	public BusinessClassReservation() {

		// Initialize flights
		flights.put("ABC123", new FlightDetails());
		flights.put("DEF456", new FlightDetails());
		flights.put("GHI789", new FlightDetails());
	}

	public BusinessClassReservation(Flight flight) {
		this.flight = flight;
		this.reservationNumber = generateReservationNumber();
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
		flight.displayFlightDetails();
	}

	private int generateReservationNumber() {
		return reservationNumber;
	}

	@Override
	public double calculateTicketPrice() {
		return flight.getFare() * 1.2;
	}

	public void showSeatType() {
		LOGGER.info("Business Class is with Window seat");
	}

	public boolean checkAvailability(Flight flight, int numOfPassengers) {
		// Check if there are enough seats available on the flight
		FlightDetails storedFlight = flights.get(flight.getFlightNumber());
		return storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers);
	}

	public boolean reserveFlight(Flight flight, int numOfPassengers) {
		// Reserve the flight for the given number of passengers
		FlightDetails storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers)) {
			storedFlight.reserveSeats(numOfPassengers);
			return true;
		}
		return false;
	}

	public double calculateTotalCost(Flight flight, int numOfPassengers) {
		// Calculate the total cost of the flight reservation
		FlightDetails storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null) {
			return storedFlight.getPrice() * numOfPassengers;
		}
		return 0.0;
	}

}

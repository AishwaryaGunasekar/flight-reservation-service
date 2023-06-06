package com.solvd.flightreservation.type;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.flightreservation.exceptions.ReservationNotFoundException;
import com.solvd.flightreservation.flight.Flight;
import com.solvd.flightreservation.flight.FlightDetails;
import com.solvd.flightreservation.interfaces.Calculateprice;
import com.solvd.flightreservation.interfaces.FlightReservation;
import com.solvd.flightreservation.interfaces.SeatType;

public class EconomyClassReservation implements FlightReservation, Calculateprice, SeatType {

	private static final Logger LOGGER = LogManager.getLogger(EconomyClassReservation.class);
	private Flight flight;
	private int reservationNumber;
	private Map<String, Flight> flights;

	public EconomyClassReservation() {

	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public EconomyClassReservation(Flight flight, int reservationNumber) {
		this.flight = flight;
		this.reservationNumber = reservationNumber;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public Map<String, Flight> getFlights() {
		return flights;
	}

	public void setFlights(Map<String, Flight> flights) {
		this.flights = flights;
	}

	@Override
	public void reserveSeat() {
		if (flight.checkAvailability()) {
			flight.bookSeat();
			LOGGER.info("Seat booked successfully!");
		} else {
			LOGGER.info("Sorry, no seats available on this flight");
			throw new ReservationNotFoundException("Unavailabilty of seat  ");
		}
	}

	@Override
	public void displayReservationDetails() {
		LOGGER.info("Reservation Number: " + reservationNumber);
	}

	@Override
	public double calculateTicketPrice() {
		return flight.getFare() * 0.8;
	}

	@Override
	public void showSeatType() {
		LOGGER.info("Aisle seat is chosen");

	}

	@Override
	public double calculateTotalCost(int numOfPassengers) {
		Flight storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null) {
			return storedFlight.getPrice(numOfPassengers);
		}
		return 0.0;
	}

	@Override
	public boolean checkAvailability(FlightDetails flightd, int numOfPassengers) {
		Flight storedFlight = flights.get(flight.getFlightNumber());
		return storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers);
	}

	@Override
	public boolean reserveFlight(FlightDetails flightd, int numOfPassengers) {
		Flight storedFlight = flights.get(flight.getFlightNumber());
		if (storedFlight != null && storedFlight.hasAvailableSeats(numOfPassengers)) {
			storedFlight.reserveSeats(numOfPassengers);
			return true;
		}
		return false;
	}

}

package com.solvd.flightreservation.type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.constants.CommonConstants;
import com.solvd.flightreservation.flight.Flight;

public class BusinessClass extends Flight {

	private static final Logger LOGGER = LogManager.getLogger(BusinessClass.class);

	private double baseFare;

	public BusinessClass() {
	}

	public BusinessClass(String flightNumber, String airline, String source, String destination, int capacity,
			int bookedSeats) {
		super(flightNumber, airline, source, destination, capacity, bookedSeats);
	}

	public BusinessClass(String flightNumber, String airline, String source, String destination, int capacity,
			double baseFare, int bookedSeats) {
		super(flightNumber, airline, source, destination, capacity, bookedSeats);
		this.baseFare = baseFare;

	}

	@Override
	public double getFare() {

		return baseFare * 2;

	}

	public double getBaseFare() {
		return baseFare;
	}

	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}

	@Override
	public void displayFlightDetails() {
		LOGGER.info("Flight Number: " + getFlightNumber());
		LOGGER.info("Airline: " + getAirline());
		LOGGER.info("Source: " + getSource());
		LOGGER.info("Destination: " + getDestination());
		LOGGER.info("Capacity: " + getCapacity());
		LOGGER.info("Booked Seats: " + getBookedSeats());
		LOGGER.info("Fare: " + getFare());

	}

	@Override
	public boolean hasAvailableSeats(int numOfPassengers) {
		if (numOfPassengers < CommonConstants.MAX_FLIGHT_CAPACITY) {
			return true;
		}
		return false;
	}

	@Override
	public void reserveSeats(int numOfPassengers) {
		Flight flight = new EconomyClass();
		if (flight.checkAvailability()) {
			LOGGER.info("Seat booked successfully!");

		} else {
			LOGGER.info("Sorry, no seats available on this flight");

		}
	}

	@Override
	public int getPrice(int numOfPassengers) {

		return (numOfPassengers * CommonConstants.FLIGHT_BASE_FARE) + CommonConstants.EXTRA_BAGGAGE_CHARGES;
	}

}

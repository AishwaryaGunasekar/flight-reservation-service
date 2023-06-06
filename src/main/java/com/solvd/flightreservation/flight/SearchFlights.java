package com.solvd.flightreservation.flight;

import java.util.ArrayList;

import com.solvd.flightreservation.type.Reservation;

public class SearchFlights  {

	private String flightNumber;
	private String airline;
	private String source;
	private String destination;
	private int capacity;
	private int bookedSeats;
	private ArrayList<Reservation> reservations;
	private String meal;
	private String dateOfJourney;

	public SearchFlights() {
	}

	public SearchFlights(String flightNumber, String airline, String source, String destination, int capacity,
			int bookedSeats) {
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.capacity = capacity;
		this.bookedSeats = bookedSeats;
		this.reservations = new ArrayList<Reservation>();
	}

	public SearchFlights(String source, String destination, String dateOfJourney) {
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void bookSeat() {
		bookedSeats++;
	}

	public boolean checkAvailability() {
		return (capacity - bookedSeats) > 0;
	}

	@Override
	public String toString() {
		return "SearchFlights [flightNumber=" + flightNumber + ", airline=" + airline + ", source=" + source
				+ ", destination=" + destination + ", capacity=" + capacity + ", bookedSeats=" + bookedSeats
				+ ", reservations=" + reservations + ", meal=" + meal + ", dateOfJourney=" + dateOfJourney + "]";
	}

}

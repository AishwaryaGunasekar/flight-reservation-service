package com.solvd.flightreservation.flight;

import java.util.ArrayList;
import java.util.List;

public class AvailableFlights {

	private String flightNumber;
	private String destination;
	private List<Pilot> pilots;

	public AvailableFlights(String flightNumber, String destination) {
		this.flightNumber = flightNumber;
		this.destination = destination;
		this.pilots = new ArrayList<>();
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void addPilot(Pilot pilot) {
		pilots.add(pilot);
	}

	public void removePilot(Pilot pilot) {
		pilots.remove(pilot);
	}
}

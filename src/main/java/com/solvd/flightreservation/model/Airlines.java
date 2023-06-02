package com.solvd.flightreservation.model;

import java.util.*;
import com.solvd.flightreservation.flight.SearchFlights;

public abstract class Airlines {
	
	private List<String> airlinesList;

	public Airlines() {

	}

	public List<String> getAirlines() {
		return airlinesList;
	}

	public void setAirlines(List<String> airlines) {
		this.airlinesList = airlines;
	}

	public abstract List<String> getAirlinesList(SearchFlights flight);

}
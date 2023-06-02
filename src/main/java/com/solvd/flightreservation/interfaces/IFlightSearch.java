package com.solvd.flightreservation.interfaces;

import java.util.List;

import com.solvd.flightreservation.flight.IFlight;

@FunctionalInterface
	public interface IFlightSearch {
	    List<IFlight> search(String departureCity);
	}






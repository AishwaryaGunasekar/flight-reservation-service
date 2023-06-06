package com.solvd.flightreservation.user;

public class PassengerDetails {

	public String getPassengerDetails(Passenger p) {

		StringBuilder sb = new StringBuilder();
		sb.append("Passenger Details for " + p.getPassportNumber() + "\n");
		sb.append("Age" + p.getAge() + "\n");
		return sb.toString();
	}

}

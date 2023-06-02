package com.solvd.flightreservation.flight;

public class FlightReservation {

	private String reservationId;
	private String passengerName;
	private String flightNumber;
	private String status;

	public FlightReservation(String reservationId, String passengerName, String flightNumber, String status) {
		this.reservationId = reservationId;
		this.passengerName = passengerName;
		this.flightNumber = flightNumber;
		this.status = status;
	}
	public FlightReservation()
	{
		
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reservation ID: " + reservationId + ", Passenger: " + passengerName + ", Flight: " + flightNumber
				+ ", Status: " + status;
	}
}

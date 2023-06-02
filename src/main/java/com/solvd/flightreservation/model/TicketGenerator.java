package com.solvd.flightreservation.model;

import java.util.Random;

import com.solvd.flightreservation.flight.FlightDetails;
import com.solvd.flightreservation.interfaces.IdGenerator;
import com.solvd.flightreservation.type.ServicesProvided;
import com.solvd.flightreservation.user.Passenger;

public class TicketGenerator implements IdGenerator {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int CODE_LENGTH = 8;
	private static final Random random = new Random();
	private Passenger passenger;
	private FlightDetails flightDetails;
	private ServicesProvided sr;
	private String status = "Not Confirmed";

	public TicketGenerator() {

	}

	public TicketGenerator(Passenger passenger, FlightDetails flightDetails, ServicesProvided sr, String status) {
		super();
		this.passenger = passenger;
		this.flightDetails = flightDetails;
		this.sr = sr;
		this.status = status;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public FlightDetails getFightDetails() {
		return flightDetails;
	}

	public void setFightDetails(FlightDetails fightDetails) {
		this.flightDetails = fightDetails;
	}

	public ServicesProvided getSr() {
		return sr;
	}

	public void setSr(ServicesProvided sr) {
		this.sr = sr;
	}

	public String generateReservationCode() {
		String code = generateRandomString(CODE_LENGTH);
		while (reservationCodeExists(code)) {
			code = generateRandomString(CODE_LENGTH);
		}
		return code;
	}

	private static String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
		}
		return sb.toString();
	}

	private static boolean reservationCodeExists(String code) {

		return false;
	}

	public String toString() {
		return "TicketGenerator [passenger=" + passenger + ", flightDetails=" + flightDetails + ", sr=" + sr
				+ ", status=" + status + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static final StringBuilder generatedTicket(TicketGenerator ticket) {
		StringBuilder sb = new StringBuilder();
		sb.append(" **** Your Ticket Confirmation **" + "\n");
		sb.append("NAME" + "\t" + "|" + "FROM" + "\t" + "|" + "TO" + "\t" + "|" + "STATUS" + "\t" + "|" + "FARE" + "\t"
				+ "|" + "DURATION" + "\t" + "|" + "\n");
		sb.append(getFullName(ticket) + "|" + ticket.getFightDetails().getSource() + "|"
				+ ticket.getFightDetails().getDestination() + "|" + ticket.getStatus() + "|"
				+ ticket.getFightDetails().getFare() + "|" + ticket.getFightDetails().getDuration() + "|");

		return sb;
	}

	private static String getFullName(TicketGenerator ticket) {

		return ticket.getPassenger().getFirstName() + " " + (ticket.getPassenger().getLastName());
	}

}

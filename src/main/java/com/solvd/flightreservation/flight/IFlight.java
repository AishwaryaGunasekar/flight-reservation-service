package com.solvd.flightreservation.flight;

public class IFlight {
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private int baseFare;
    private int availableSeats;

    public IFlight(String flightNumber, String departureCity, String arrivalCity, int baseFare) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.baseFare = baseFare;
        this.availableSeats = 100;
    }

    public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public void setBaseFare(int baseFare) {
		this.baseFare = baseFare;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public int getBaseFare() {
        return baseFare;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        availableSeats -= numSeats;
    }

    @Override
    public String toString() {
        return "Flight #" + flightNumber + " from " + departureCity + " to " + arrivalCity +
                " (base fare: " + baseFare + ", available seats: " + availableSeats + ")";
    }
}

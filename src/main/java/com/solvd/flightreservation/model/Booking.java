package com.solvd.flightreservation.model;

import java.util.List;

import com.solvd.flightreservation.enums.CabinClass;
import com.solvd.flightreservation.enums.PaymentMethod;
import com.solvd.flightreservation.flight.IFlight;
import com.solvd.flightreservation.user.Passenger;

public class Booking {
	
    private IFlight flight;
    private CabinClass cabinClass;
    private List<Passenger> passengerList;
    private PaymentMethod paymentMethod;

    public Booking(IFlight flight, CabinClass cabinClass, List<Passenger> passengerList, PaymentMethod paymentMethod) {
        this.flight = flight;
        this.cabinClass = cabinClass;
        this.passengerList = passengerList;
        this.paymentMethod = paymentMethod;
    }

    public IFlight getFlight() {
        return flight;
    }

    public void setFlight(IFlight flight) {
		this.flight = flight;
	}

	public void setCabinClass(CabinClass cabinClass) {
		this.cabinClass = cabinClass;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public CabinClass getCabinClass() {
        return cabinClass;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public String toString() {
        return "Booking for " + passengerList.size() + " passengers on Flight #" + flight.getFlightNumber() +
                " (" + cabinClass + ", " + paymentMethod + ")";
    }
}


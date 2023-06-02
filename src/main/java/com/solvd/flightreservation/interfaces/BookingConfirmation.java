package com.solvd.flightreservation.interfaces;

import com.solvd.flightreservation.model.Booking;

@FunctionalInterface
public interface BookingConfirmation {
	boolean confirmBooking(Booking booking);
}

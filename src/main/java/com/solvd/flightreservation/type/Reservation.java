package com.solvd.flightreservation.type;


public class Reservation {
	
	private int reservationId;
	private String passengerName;
	private String passengerContactNumber;
	private String passengerEmail;
	private String seatPreference;
	private boolean mealPreference;
	private boolean drinkPreference;

	public Reservation(int reservationId, String passengerName, String passengerContactNumber, String passengerEmail,
			String seatPreference, boolean mealPreference, boolean drinkPreference) {
		this.reservationId = reservationId;
		this.passengerName = passengerName;
		this.passengerContactNumber = passengerContactNumber;
		this.passengerEmail = passengerEmail;
		this.seatPreference = seatPreference;
		this.mealPreference = mealPreference;
		this.drinkPreference = drinkPreference;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerContactNumber() {
		return passengerContactNumber;
	}

	public void setPassengerContactNumber(String passengerContactNumber) {
		this.passengerContactNumber = passengerContactNumber;
	}

	public String getPassengerEmail() {
		return passengerEmail;
	}

	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}

	public String getSeatPreference() {
		return seatPreference;
	}

	public void setSeatPreference(String seatPreference) {
		this.seatPreference = seatPreference;
	}

	public boolean hasMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(boolean mealPreference) {
		this.mealPreference = mealPreference;
	}

	public boolean hasDrinkPreference() {
		return drinkPreference;
	}

	public void setDrinkPreference(boolean drinkPreference) {
		this.drinkPreference = drinkPreference;
	}

	@Override
	public String toString() {
		return "Reservation{" + "reservationId=" + reservationId + ", passengerName='" + passengerName + '\''
				+ ", passengerContactNumber='" + passengerContactNumber + '\'' + ", passengerEmail='" + passengerEmail
				+ '\'' + ", seatPreference='" + seatPreference + '\'' + ", mealPreference=" + mealPreference
				+ ", drinkPreference=" + drinkPreference + '}';
	}

	
}

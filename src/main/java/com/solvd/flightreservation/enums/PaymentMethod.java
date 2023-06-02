package com.solvd.flightreservation.enums;

public enum PaymentMethod {

	CREDIT_CARD("Credit Card"), DEBIT_CARD("Debit Card"), PAYPAL("PayPal");

	private String name;

	PaymentMethod(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}

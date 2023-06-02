package com.solvd.flightreservation.enums;

public enum CabinClass {

	ECONOMY("Economy", 1.0), PREMIUM_ECONOMY("Premium Economy", 1.2), BUSINESS("Business", 2.0), FIRST("First", 3.0);

	private final String name;
	private final double fareMultiplier;

	CabinClass(String name, double fareMultiplier) {
		this.name = name;
		this.fareMultiplier = fareMultiplier;
	}

	public String getName() {
		return name;
	}

	public double getFareMultiplier() {
		return fareMultiplier;
	}
}

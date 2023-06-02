package com.solvd.flightreservation.enums;

public enum MealType {

	NO_MEAL("No Meal", false), VEGETARIAN("Vegetarian", true), NON_VEGETARIAN("Non-Vegetarian", false),
	VEGAN("Vegan", true);

	private final String name;
	private final boolean isVegetarian;

	MealType(String name, boolean isVegetarian) {
		this.name = name;
		this.isVegetarian = isVegetarian;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}
}

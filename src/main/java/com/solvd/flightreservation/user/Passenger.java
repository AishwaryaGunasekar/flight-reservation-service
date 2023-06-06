package com.solvd.flightreservation.user;

import com.solvd.flightreservation.enums.MealType;

public class Passenger

{
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String passportNumber;
	private String phoneNumber;
	public MealType mealType;

	public Passenger(String firstName, MealType mealType) {
		super();
		this.firstName = firstName;
		this.mealType = mealType;
	}

	public Passenger(String firstName, String lastName, int age, String gender, String passportNumber,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.passportNumber = passportNumber;
		this.phoneNumber = phoneNumber;
	}

	public Passenger(String firstName, int age, String passportNumber) {
		this.firstName = firstName;
		this.age = age;
		this.passportNumber = passportNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", passportNumber=" + passportNumber + ", phoneNumber=" + phoneNumber + "]";
	}

}
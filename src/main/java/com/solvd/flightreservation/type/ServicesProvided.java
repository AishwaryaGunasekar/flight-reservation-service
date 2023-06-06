package com.solvd.flightreservation.type;

import java.util.List;
import com.solvd.flightreservation.constants.CommonConstants;
import com.solvd.flightreservation.exceptions.InvalidSeatTypeException;
import com.solvd.flightreservation.interfaces.IService;

public class ServicesProvided implements IService

{
	public static final String ECONOMY = "economy";
	public static final String BUSINESS = "business";
	private String mealType;
	private String extraLegRoom;
	private String classType;

	public ServicesProvided() {

	}

	public ServicesProvided(String mealType, String extraLegRoom) {
		super();
		this.mealType = mealType;
		this.extraLegRoom = extraLegRoom;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getExtraLegRoom() {
		return extraLegRoom;
	}

	public void setExtraLegRoom(String extraLegRoom) {
		this.extraLegRoom = extraLegRoom;
	}

	public ServicesProvided(String classType) {
		this.classType = classType;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}
	@Override
	public List<String> getServices() {
		if (classType.equalsIgnoreCase(ECONOMY)) {
			return CommonConstants.ECONOMY_SERVICES;
		} else if (classType.equalsIgnoreCase(BUSINESS)) {
			return CommonConstants.BUSINESS_SERVICES;
		} else {
			throw new InvalidSeatTypeException(
					"Choose Economy or Businees ,other seatType or class type is unavailable");

		}

	}

	@Override
	public String toString() {
		return "ServicesProvided [mealType=" + mealType + ", extraLegRoom=" + extraLegRoom + ", classType=" + classType
				+ "]";
	}
}


package com.solvd.flightreservation.flight;

public class Pilot {

	private String pilotName;
	private long phoneNumber;
	private String pilotID;

	public Pilot(String pilotName, long phoneNumber, String pilotID) {
		super();
		this.pilotName = pilotName;
		this.phoneNumber = phoneNumber;
		this.pilotID = pilotID;
	}

	public Pilot(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPilotID() {
		return pilotID;
	}

	public void setPilotID(String pilotID) {
		this.pilotID = pilotID;
	}

}

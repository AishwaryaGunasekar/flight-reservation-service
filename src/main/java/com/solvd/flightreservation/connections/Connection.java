package com.solvd.flightreservation.connections;

public class Connection {

	private String name;
	private int id;

	public Connection(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Connection(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

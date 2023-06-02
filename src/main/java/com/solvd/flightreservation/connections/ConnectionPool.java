package com.solvd.flightreservation.connections;

import java.util.List;
import java.util.ArrayList;

public class ConnectionPool {

	private static ConnectionPool instance;
	private List<Connection> connections;

	private ConnectionPool() {
		connections = new ArrayList<>();
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			synchronized (ConnectionPool.class) {
				if (instance == null) {
					instance = new ConnectionPool();
				}
			}
		}
		return instance;
	}

	public synchronized void addConnection(Connection connection) {
		connections.add(connection);
	}

	public synchronized Connection getConnection() {
		if (connections.size() > 0) {
			return connections.remove(connections.size() - 1);
		}
		return null;
	}

	public int getConnectionCount() {
		return connections.size();
	}
}

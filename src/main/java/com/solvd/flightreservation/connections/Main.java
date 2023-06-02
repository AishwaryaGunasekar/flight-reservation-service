package com.solvd.flightreservation.connections;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		ConnectionPool connectionPool = ConnectionPool.getInstance();

		// Adding connections to the connection pool
		connectionPool.addConnection(new Connection("Connection 1"));
		connectionPool.addConnection(new Connection("Connection 2"));
		connectionPool.addConnection(new Connection("Connection 3"));
		connectionPool.addConnection(new Connection("Connection 4"));

		// Creating worker threads to retrieve connections from the connection pool
		int workCount = 5;

		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < workCount; i++) {
			Thread thread = new Thread(() -> {
				Connection connection = connectionPool.getConnection();
				if (connection != null) {
					LOGGER.info("Connection Name: " + connection.getName() + "Connection ID: " + connection.getId());
				} else {
					LOGGER.error("No connections available in the connection pool.");
				}
			});
			threads.add(thread);
			thread.start();
		}

		// Wait for all worker threads to complete
		threads.forEach(thread -> {
			try {
				thread.join();
			} catch (InterruptedException e) {
				LOGGER.error("Exception occurred:");
				e.printStackTrace(System.out);
			}
		});
	}
}

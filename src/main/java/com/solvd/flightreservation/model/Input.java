package com.solvd.flightreservation.model;

import java.util.Scanner;

public class Input {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static String getString(String message) {
		System.out.println(message);
		return scanner.nextLine();
	}

	public static int getInt(String message) {
		try {
			System.out.println(message);
			return scanner.nextInt();
		} finally {
			scanner.nextLine();
		}
	}

	public static long getLong(String message) {
		try {
			System.out.println(message);
			return scanner.nextLong();
		} finally {
			scanner.nextLine();
		}
	}

	public static float getFloat(String message) {
		try {
			System.out.println(message);
			return scanner.nextFloat();
		} finally {
			scanner.nextLine();
		}
	}

	public static double getDouble(String message) {
		try {
			System.out.println(message);
			return scanner.nextDouble();
		} finally {
			scanner.nextLine();
		}
	}

	public static boolean getBoolean(String message) {
		try {
			System.out.println(message);
			return scanner.nextBoolean();
		} finally {
			scanner.nextLine();
		}
	}

	public static void close() {
		scanner.close();
	}
}

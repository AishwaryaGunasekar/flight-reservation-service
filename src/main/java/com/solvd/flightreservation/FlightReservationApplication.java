package com.solvd.flightreservation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.enums.CabinClass;
import com.solvd.flightreservation.enums.MealType;
import com.solvd.flightreservation.enums.PaymentMethod;
import com.solvd.flightreservation.flight.AvailableFlights;
import com.solvd.flightreservation.flight.FlightDetails;
import com.solvd.flightreservation.flight.FlightReservation;
import com.solvd.flightreservation.flight.IFlight;
import com.solvd.flightreservation.flight.Pilot;
import com.solvd.flightreservation.flight.SearchFlights;
import com.solvd.flightreservation.interfaces.BookingConfirmation;
import com.solvd.flightreservation.interfaces.IFlightSearch;
import com.solvd.flightreservation.model.Booking;
import com.solvd.flightreservation.model.Input;
import com.solvd.flightreservation.model.TicketGenerator;
import com.solvd.flightreservation.payment.CreditCardPayment;
import com.solvd.flightreservation.type.BusinessClass;
import com.solvd.flightreservation.type.BusinessClassReservation;
import com.solvd.flightreservation.type.EconomyClass;
import com.solvd.flightreservation.type.EconomyClassReservation;
import com.solvd.flightreservation.type.ServicesProvided;
import com.solvd.flightreservation.user.Passenger;
import com.solvd.flightreservation.user.PassengerDetails;
import com.solvd.flightreservation.utilities.CustomLinkedListImpl;

public class FlightReservationApplication {

	private static final Logger LOGGER = LogManager.getLogger(FlightReservationApplication.class);

	public static void main(String[] args) throws IOException {

		LOGGER.info("-----------------------------------------------------------------------------!");

		LOGGER.info("*******Welcome to FLY EASY.COM ********");

		LOGGER.info("Where are you flying?");

		boolean exit = false;
		while (!exit) {

			String selectedOption = Input.getString("Press \"OK\" proceed with booking or \"Exit\" To Quit:");

			if (selectedOption.equals("Exit")) {
				exit = true;
				LOGGER.info("Goodbye!");
				Input.close();
			} else if (selectedOption.equals("Ok")) {
				LOGGER.info("Where Are you Flying ??");
			}
			// Flight Details
			List<FlightDetails> flightDetailsList = Arrays.asList(
					new FlightDetails("EK143", "Emirates", "MAA", "DXB", 18500, "3h30m", "1stop"),
					new FlightDetails("EK143", "QATAR", "MAA", "PHA", 25500, "20h30m", "2stop"));

			while (!exit) {

				// Search Flights
				SearchFlights flight = null;
				String source = Input.getString("Please input From:");
				String destination = Input.getString("Please input To:");
				String date = Input.getString("Please Input date of journey ");

				flight = new SearchFlights(source, destination, date);
				LOGGER.info("Flight Details " + "\n" + flight);

				Integer selectedFlight = Input
						.getInt("#1" + "\n" + flightDetailsList.get(0) + "\n #2" + "\n" + flightDetailsList.get(1));

				if ("1".equalsIgnoreCase(selectedFlight.toString())
						|| "2".equalsIgnoreCase(selectedFlight.toString())) {
					LOGGER.info("Seats Available, proceed to booking !!!");
				} else {
					LOGGER.error(" !! Wrong Entry !! ");
				}

				// Passenger Details
				Passenger passenger = null;
				String firstName = Input.getString("\nPlease input your FIRST NAME:");
				String lastName = Input.getString("\nPlease input your LAST NAME:");
				int age = Input.getInt("\nPlease input your AGE:");
				String gender = Input.getString("\nPlease input your Gender:");
				String passportNumber = Input.getString("\nPlease input your PASSPORT NUMBER:");
				String phoneNumber = Input.getString("\nPlease input your phone number");
				passenger = new Passenger(firstName, lastName, age, gender, passportNumber, phoneNumber);

				String confirmPassenger = Input.getString("Press \"Yes\" proceed with bookoking or \"Exit\" To Quit:");
				ServicesProvided sr = null;
				if ("Yes".equalsIgnoreCase(confirmPassenger)) {

					String mealType = Input.getString("Please Input your Meal Type: " + "\n" + "#1" + " Veg" + "\n"
							+ "#2" + " Non Veg" + "\n" + "#3" + " Vegan");
					String extraLegRoom = Input.getString("Press \"Yes\" for extra leg room or \"No\" :");
					sr = new ServicesProvided(mealType, extraLegRoom);
				} else {

					LOGGER.error(" !! Wrong Entry !! ");

				}
				
				//Passenger Details 
				PassengerDetails pd = new PassengerDetails();
				pd.getPassengerDetails(passenger);

				// Ticket Generation
				TicketGenerator ticket = new TicketGenerator();
				ticket.setPassenger(passenger);
				ticket.setFightDetails(flightDetailsList.get(selectedFlight - 1));
				ticket.setSr(sr);
				LOGGER.info("** Your Ticket Summary **: " + "\n" + ticket);

				long cardNumber = Input.getLong("\nPlease input your 16 digits card number: ");
				CreditCardPayment.processPayment(cardNumber, ticket);
				LOGGER.info("Thank you for your payment!");
				LOGGER.info(TicketGenerator.generatedTicket(ticket));
				LOGGER.info("Thankyou for choosing Fly Easy. Have a Safe Journey !! ");

				TicketGenerator tg = new TicketGenerator();
				String reservationCode = tg.generateReservationCode();
				LOGGER.info("Reservation code: " + reservationCode);

				exit = true;
				Input.close();

				// Reflection concept is used here
				try {
					// Get the FlightReservation class using reflection
					Class<?> flightReservationClass = Class
							.forName("com.solvd.flightreservation.flight.FlightReservation");

					// Get the constructor of the FlightReservation class
					Constructor<?> constructor = flightReservationClass.getConstructor(String.class, String.class,
							String.class, String.class);

					// Generate flight reservations
					for (int i = 1; i <= 5; i++) {
						// Create a new instance of FlightReservation
						Object flightReservation = constructor.newInstance("Reservation" + i, "Passenger" + i,
								"Flight" + i, "CONFIRMED");

						// Set the status field using reflection
						Field statusField = flightReservationClass.getDeclaredField("status");
						statusField.setAccessible(true);
						statusField.set(flightReservation, "PENDING");

						// Print the generated flight reservation
						LOGGER.info(flightReservation);
					}
				} catch (Exception e) {
					LOGGER.error("Exception occurred:");
					e.printStackTrace(System.out);
				}

				// Streaming API is used here
				List<FlightReservation> flightReservationsList = Arrays.asList(
						new FlightReservation("1", "Guna", "ABC123", "CONFIRMED"),
						new FlightReservation("2", "Padma", "DEF456", "PENDING"),
						new FlightReservation("3", "Aishu", "GHI789", "CANCELLED"),
						new FlightReservation("4", "Abi", "JKL012", "CONFIRMED"),
						new FlightReservation("5", "Ananya", "MNO345", "CONFIRMED"));

				// Filtering flight reservations with status "CONFIRMED"

				flightReservationsList.stream().filter(reservation -> reservation.getStatus().equals("CONFIRMED"))
						.forEach(System.out::println);

				// Counting the number of flight reservations with status "PENDING"
				long pendingCount = flightReservationsList.stream()
						.filter(reservation -> reservation.getStatus().equals("PENDING")).count();
				// counting the number of flight reservations that were cancelled
				long cancelCount = flightReservationsList.stream()
						.filter(reservation -> reservation.getStatus().equals("CANCELLED")).count();

				LOGGER.info("Number of pending reservations: " + pendingCount);

				LOGGER.info("Number of cancelled :" + cancelCount);

				// instantiated and used to store and manipulate strings.

				CustomLinkedListImpl<String> stringList = new CustomLinkedListImpl<String>();

				stringList.add("Name");
				stringList.add("PassportNo");
				stringList.remove("");

				boolean containsPassportNo = stringList.contains("PassportNo");
				if (containsPassportNo) {
					LOGGER.info("List contains passportno.");
				} else {
					LOGGER.error("List does not contain passportno.");
				}
			}

			LOGGER.info("************");

			IFlight flight1 = new IFlight("ABC123", "New York", "London", 500);
			IFlight flight2 = new IFlight("XYZ456", "London", "Paris", 300);
			IFlight flight3 = new IFlight("DEF789", "New York", "Paris", 600);
			List<IFlight> flights = Arrays.asList(flight1, flight2, flight3);

			// Using IFlightSearch functional interface to search for flights by departure
			// city
			IFlightSearch searchByDepartureCity = (String departureCity) -> {
				List<IFlight> results = new ArrayList<>();
				for (IFlight t : flights) {
					if (t.getDepartureCity().equals(departureCity)) {
						results.add(t);
					}
				}
				return results;
			};
			List<IFlight> flightsFromNewYork = searchByDepartureCity.search("New York");
			LOGGER.info("Flights from New York:");
			flightsFromNewYork.forEach(System.out::println);

			// Using BookingConfirmation functional interface to confirm a booking
			BookingConfirmation bc = (Booking booking) -> {
				if (booking.getPassengerList().size() > booking.getFlight().getAvailableSeats()) {
					return false;
				}
				booking.getFlight().bookSeats(booking.getPassengerList().size());
				return true;
			};

			IFlight sselectedFlight = flight1;
			CabinClass selectedCabinClass = CabinClass.BUSINESS;
			List<Passenger> passengers = Arrays.asList(new Passenger("John Doe", MealType.VEGETARIAN),
					new Passenger("Jane Doe", MealType.NON_VEGETARIAN));
			Booking booking = new Booking(sselectedFlight, selectedCabinClass, passengers, PaymentMethod.CREDIT_CARD);
			boolean isBookingConfirmed = bc.confirmBooking(booking);
			if (isBookingConfirmed) {
				LOGGER.info("Booking confirmed!");
			} else {
				LOGGER.error(
						"Booking could not be confirmed. Please select a different flight or reduce the number of passengers.");
			}

			// Using existing Consumer functional interface to print out all flights
			Consumer<IFlight> printFlightDetails = (IFlight iflight) -> {
				LOGGER.info("Flight #" + iflight.getFlightNumber() + " from " + iflight.getDepartureCity() + " to "
						+ iflight.getArrivalCity());
			};
			LOGGER.info("All available flights:");
			flights.forEach(printFlightDetails);

			// Using existing Predicate functional interface to filter flights with a base
			// fare less than 200
			Predicate<IFlight> low = (IFlight iflight) -> iflight.getBaseFare() < 200;
			List<IFlight> lowFareFlights = flights.stream().filter(low).collect(Collectors.toList());
			LOGGER.info("Flights with base fare less than 200:");
			lowFareFlights.forEach(System.out::println);
		}

		EconomyClass ec = new EconomyClass();
		ec.displayFlightDetails();

		BusinessClass bc = new BusinessClass();
		bc.displayFlightDetails();

		BusinessClassReservation bcReservation = new BusinessClassReservation();
		bcReservation.displayReservationDetails();

		EconomyClassReservation ecReservation = new EconomyClassReservation();
		ecReservation.displayReservationDetails();

		// Create Flight objects for available flight class to retrieve the pilots for
		// the created flights
		AvailableFlights av = new AvailableFlights("F001", "Destination 1");
		AvailableFlights av1 = new AvailableFlights("F002", "Destination 2");

		// Create Pilot objects
		Pilot pilot1 = new Pilot("Madhan");
		Pilot pilot2 = new Pilot("Malani");

		// Add pilots to flights
		av.addPilot(pilot1);
		av.addPilot(pilot2);
		av1.addPilot(pilot2);

		// Get pilots of a flight
		List<Pilot> flight1Pilots = av.getPilots();
		LOGGER.info("Pilots of Flight 1:");
		for (Pilot pilot : flight1Pilots) {
			LOGGER.info(pilot.getPilotName());
		}

		List<Pilot> flight2Pilots = av1.getPilots();
		LOGGER.info("Pilots of Flight 2:");
		for (Pilot pilot : flight2Pilots) {
			LOGGER.info(pilot.getPilotName());
		}
	}
}

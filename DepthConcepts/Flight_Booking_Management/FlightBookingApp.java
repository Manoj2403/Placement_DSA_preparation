// package Flight_Booking_Management;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightBookingApp {
    static FlightBookingSystem bookingSystem;

    public static void printFlightDetails(Flight flight) {
        System.out.println("---------------------------");
        System.out.println("Flight ID : " + flight.getFlightId());
        System.out.println("Airplane Model : " + flight.getAirplane().getModelName());
        System.out.println("From : " + flight.getDepartureLocation().toUpperCase());
        System.out.println("To : " + flight.getArrivalLocation().toUpperCase());
        System.out.println("Date : " + flight.getDate());
        System.out.println("Available Seats : " + flight.getAvailableSeats());
        System.out.println("*******Kindly Note the Flight Id to Book Flight for you Journey******");
    }

    public static void main(String[] args) {
        bookingSystem = new FlightBookingSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1) Add Flight\n 2) Book Flight\n 3) View Flights\n 4) Cancel Flight\n 5) Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Choose Airplane Model for Your Flight\n");
                System.out.println("1) Airbus A320");
                System.out.println("2) Boeing B777");
                int choiceIdx = sc.nextInt();
                Airplane selectedAirplane = null;
                if (choiceIdx == 1) {
                    selectedAirplane = new Airbus();

                } else if (choiceIdx == 2) {
                    selectedAirplane = new Boeing();
                }
                System.out.println("Enter Flight Id:");
                int flightId = sc.nextInt();
                System.out.println("Enter Departure Location:");
                String departure = sc.next();
                System.out.println("Enter Arrival Location:");
                String arrival = sc.next();
                System.out.println("Enter Date (YYYY-MM-DD):");
                String date = sc.next();
                System.out.println("Enter Time (HH:MM):");
                String time = sc.next();

                // String combinedDate = date +"T"+time;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                LocalDate parsedLocalDate = LocalDate.parse(date, formatter);

                LocalTime parsedLocalTime = LocalTime.parse(time);

                LocalDateTime combinedDateTime = parsedLocalDate.atTime(parsedLocalTime);

                bookingSystem.addFlight(flightId, selectedAirplane, departure, arrival, combinedDateTime);

            } else if (choice == 2) {
                sc.nextLine();
                System.out.println("Enter From Location : ");
                String from = sc.nextLine();
                System.out.println("Enter To Location : ");
                String to = sc.nextLine();
                System.out.println("Enter Date : (yyyy-MM-dd)");
                String date = sc.nextLine();
                System.out.println("Enter Time (HH:MM):");
                String time = sc.next();
                List<Flight> availableFlights = bookingSystem.getAvailableFlights(from, to,
                        bookingSystem.getParsedDateTime(date, time));
                System.out.println(availableFlights.size() + " Flights are available from " + from.toUpperCase()
                        + " to " + to.toUpperCase());
                // If no Flights are available - continue
                if (availableFlights.isEmpty()) {
                    continue;
                }
                // If flights are available Printing Details
                for (Flight flight : availableFlights) {
                    printFlightDetails(flight);
                }

                System.out.println("Enter Flight ID to book Flight Ticket : ");
                int flightId = sc.nextInt();

                System.out.println("Enter Passenger Details : ");
                System.out.println("Enter Name : ");
                String name = sc.nextLine();
                System.out.println("Enter Your Age : ");
                int age = sc.nextInt();
                System.out.println("Enter Mobile Number : ");
                long phoneNo = sc.nextLong();
                Passenger passenger = new Passenger();
                passenger.setName(name);
                passenger.setAge(age);
                passenger.setContactNo(phoneNo);

                bookingSystem.showSeatLayout(flightId);
                System.out.println("Enter Seat No : ");
                String seatNo = sc.nextLine();
                System.out.println("Enter Seat Model : (Economic/Model/First)");
                String seatModel = sc.nextLine();
                bookingSystem.bookFlight(flightId, passenger, seatNo, seatModel);
            } else if (choice == 3) {
                System.out.println("Enter From Location : ");
                String from = sc.nextLine();
                System.out.println("Enter To Location : ");
                String to = sc.nextLine();
                System.out.println("Enter Date : (yyyy-MM-dd)");
                String date = sc.nextLine();
                System.out.println("Enter Time (HH:MM):");
                String time = sc.next();

                List<Flight> availableFlights = bookingSystem.getAvailableFlights(from, to,
                        bookingSystem.getParsedDateTime(date, time));
                        
                System.out.println(availableFlights.size() + " Flights are available from " + from.toUpperCase()
                        + " to " + to.toUpperCase());

                for (Flight flight : availableFlights) {
                    printFlightDetails(flight);
                }
            } else if (choice == 5) {
                System.exit(0);
            }
        }
    }
}

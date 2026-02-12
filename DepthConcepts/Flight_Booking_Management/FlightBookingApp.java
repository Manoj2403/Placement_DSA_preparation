// package Flight_Booking_Management;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightBookingApp {
    static FlightBookingSystem bookingSystem;
    private static final String regex = "^[a-zA-Z\\s]+$";

    public static void printFlightDetails(Flight flight) {
        System.out.println("======================================================================");
        System.out.println("Flight ID       : " + flight.getFlightId());
        System.out.println("Airplane Model  : " + flight.getAirplane().getModelName());
        System.out.println("From            : " + flight.getDepartureLocation().toUpperCase());
        System.out.println("To              : " + flight.getArrivalLocation().toUpperCase());
        System.out.println("Date            : " + flight.getDate());
        System.out.println("Available Seats : " + flight.getAvailableSeats());
        System.out.println("*******Kindly Note the Flight Id to Book Flight for you Journey******");
        System.out.println("======================================================================");
    }

    public static boolean isValidString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        return str.matches(regex);
    }

    public static boolean isValidDate(String date) {
        if (date == null || date.trim().isEmpty()) {
            return false;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidTime(String time) {
        if (time == null || time.trim().isEmpty())
            return false;
        try {
            LocalTime.parse(time);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isBothSameLocation(String from, String to) {
        return from.equalsIgnoreCase(to);
    }

    public static void main(String[] args) {
        bookingSystem = new FlightBookingSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1) Add Flight\n2) Book Flight\n3) View Flights\n4) Cancel Flight\n5) Exit");
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
                String departure = null;
                String arrival = null;
                String date = null;
                String time = null;
                while (true) {
                    System.out.println("Enter Departure Location:");
                    departure = sc.next();
                    if (isValidString(departure)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Arrival Location:");
                    arrival = sc.next();
                    if (isValidString(arrival)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Date (YYYY-MM-DD):");
                    date = sc.next();
                    if (isValidDate(date)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Time (HH:MM):");
                    time = sc.next();
                    if (isValidTime(time)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }

                // String combinedDate = date +"T"+time;

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                LocalDate parsedLocalDate = LocalDate.parse(date, formatter);

                LocalTime parsedLocalTime = LocalTime.parse(time);

                LocalDateTime combinedDateTime = parsedLocalDate.atTime(parsedLocalTime);

                bookingSystem.addFlight(flightId, selectedAirplane, departure, arrival, combinedDateTime);
                System.out.println("-------------------------------");

            } else if (choice == 2) {
                sc.nextLine();
                String from = null;
                String to = null;
                String date = null;
                String time = null;
                while (true) {
                    System.out.println("Enter Departure Location:");
                    from = sc.next();
                    if (isValidString(from)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Arrival Location:");
                    to = sc.next();
                    if (isValidString(to)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Date (YYYY-MM-DD):");
                    date = sc.next();
                    if (isValidDate(date)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Time (HH:MM):");
                    time = sc.next();
                    if (isValidTime(time)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }

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

                System.out.println("================================");
                System.out.println("    Enter Passenger Details");
                System.out.println("================================");

                String name = null;
                while (true) {
                    sc.nextLine();
                    System.out.println("Enter Name : ");
                    name = sc.nextLine();
                    if (isValidString(from)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                System.out.println("Enter Your Age : ");
                int age = sc.nextInt();
                System.out.println("Enter Mobile Number : ");
                long phoneNo = sc.nextLong();
                Passenger passenger = new Passenger();
                passenger.setName(name);
                passenger.setAge(age);
                passenger.setContactNo(phoneNo);
                System.out.println("================================");

                bookingSystem.showSeatLayout(flightId);
                sc.nextLine();
                System.out.println("Enter Seat No : ");
                String seatNo = sc.nextLine();
                System.out.println("Enter Seat Model : (Economic/Model/First)");
                String seatModel = sc.nextLine();
                Ticket bookedTicket = bookingSystem.bookFlight(flightId, passenger, seatNo, seatModel);
                if (bookedTicket != null) {
                    System.out.println("Flight Booked Successfully");
                    System.out.println(bookedTicket);
                } else {
                    System.out.println("Flight Not Booked Successfully..");
                }
                System.out.println("--------------------------------");
            } else if (choice == 3) {
                String from = null;
                String to = null;
                String date = null;
                String time = null;
                while (true) {
                    System.out.println("Enter Departure Location:");
                    from = sc.next();
                    if (isValidString(from)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Arrival Location:");
                    to = sc.next();
                    if (isValidString(to)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Date (YYYY-MM-DD):");
                    date = sc.next();
                    if (isValidDate(date)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }
                while (true) {
                    System.out.println("Enter Time (HH:MM):");
                    time = sc.next();
                    if (isValidTime(time)) {
                        break;
                    }
                    System.out.println("***Kindly Enter Correct String format***");
                }

                List<Flight> availableFlights = bookingSystem.getAvailableFlights(from, to,
                        bookingSystem.getParsedDateTime(date, time));

                System.out.println(availableFlights.size() + " Flights are available from " + from.toUpperCase()
                        + " to " + to.toUpperCase());

                for (Flight flight : availableFlights) {
                    printFlightDetails(flight);
                    bookingSystem.showSeatLayout(flight.getFlightId());
                }

                System.out.println("--------------------------------");
            } else if (choice == 4) {
                System.out.println("********Cancelling Flights********");
                System.out.println("Enter Ticket Id to Cancel Flight :  ");
                int ticketId = sc.nextInt();
                sc.nextLine();
                Ticket bookedTicket = bookingSystem.getTicket(ticketId);
                if (bookedTicket == null) {
                    System.out.println("Ticket was Not Found..");
                    continue;
                }
                if (bookedTicket.getStatus() == Status.NOT_ACTIVE) {
                    System.out.println("Ticket is Not Active..");
                    continue;
                }
                Flight flight = bookedTicket.getFlight();
                Passenger passenger = bookedTicket.getPassenger();
                System.out.println("===================================");
                System.out.println("--- Ticket Details ---");
                System.out.println("===================================");
                System.out.println("Flight: " + flight.getFlightId());
                System.out.println("From: " + flight.getDepartureLocation());
                System.out.println("To: " + flight.getArrivalLocation());
                System.out.println("Seat: " + bookedTicket.getSeatNo());
                System.out.println("*************************************");
                System.out.println("--- Passenger Details ---");
                System.out.println("Passenger: " + passenger.getName());
                System.out.println("Passenger ID: " + passenger.getPassengerId());
                System.out.println("===================================");

                System.out.println("Confirm Cancellation? (YES/NO)");
                String cancelChoice = sc.nextLine();
                if(cancelChoice.equalsIgnoreCase("no")){
                    System.out.println("Cancel Aborted....");
                    continue;
                }

                Result result = bookingSystem.cancelFlight(bookedTicket);
                if (!(result.isSuccess())) {
                    System.out.println(result.getMessage());
                    continue;
                }
                System.out.println("Ticket cancelled SUccessfully..");

            } else if (choice == 5) {
                System.exit(0);
            }
        }
    }
}

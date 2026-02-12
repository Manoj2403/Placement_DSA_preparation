// package Flight_Booking_Management;

import java.util.*;
import java.util.stream.Collectors;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FlightBookingSystem {
    List<Flight> flights;
    List<Ticket> tickets;

    FlightBookingSystem() {
        flights = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void addFlight(int flightId, Airplane airplane, String departureLocation, String arrivalLocation,
            LocalDateTime date) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                System.out.println("Flight Already Exists..");
                return;
            }
        }
        Flight flight = new Flight(flightId, airplane, departureLocation.toLowerCase(), arrivalLocation.toLowerCase(),
                date, new ArrayList<>());
        flights.add(flight);
        System.out.println("Flight Added Successfully....");
    }

    public Ticket bookFlight(int flightId, Passenger passenger, String seatNo, String model) {
        Flight flight = getFlighById(flightId);
        if (flight == null) {
            System.out.println("Flight Not Exists..");
            return null;
        }
        if (checkDuplicatePassenger(flight, passenger.getPassengerId())) {
            System.out.println("Passenger Already Booked the Flight " + flightId);
            return null;
        }

        int seatRow = getSeatNo(seatNo);
        if (seatRow <= 0) {
            System.out.println("Enter Valid Seat Number..");
            return null;
        }
        model = model.toLowerCase();
        if (model.equals("economic")) {
            if (!flight.getAirplane().isEconomicClass(seatRow))
                return null;
        } else if (model.equals("first")) {
            if (!flight.getAirplane().isFirstClass(seatRow))
                return null;
        } else if (model.equals("business")) {
            if (!flight.getAirplane().isBusinessClass(seatRow))
                return null;
        }
        int seatCol = getSeatCol(seatNo);
        if (!checkFlightSeatAvail(flight, seatRow - 1, seatCol)) {
            System.out.println(seatNo + " Seat is Already Reserved");
            return null;
        }

        boolean[][] seat = flight.getAirplane().getSeats();
        seat[seatRow - 1][seatCol] = true;
        flight.getPassengerList().add(passenger);
        passenger.setBookedFlight(flight);
        Ticket ticket = new Ticket(passenger, flight, LocalDateTime.now(), seatNo,Status.ACTIVE);
        tickets.add(ticket);
        return ticket;
    }

    public Ticket getTicket(int ticketId){
        for(Ticket ticket : tickets){
            if(ticketId==ticket.getTicketNo()){
                return ticket;
            }
        }
        return null;
    }
    public Result cancelFlight(Ticket ticket) {
        if(ticket==null){
            return new Result(false,"Ticket was Not Found.");
        }
        if(ticket.getStatus()==Status.NOT_ACTIVE){
            return new Result(false, "Ticket was Not Active.");
        }
        Flight bookedFlight = ticket.getFlight();
        boolean[][] seats = bookedFlight.getAirplane().getSeats();

        int seatRow = getSeatNo(ticket.getSeatNo()); //1,2,3,4.....
        int seatCol = getSeatCol(ticket.getSeatNo()); //A,B,C,D

        seats[seatRow-1][seatCol] = false;
        ticket.setStatus(Status.NOT_ACTIVE);
        return new Result(true,"Success");
    }

    public boolean checkFlightSeatAvail(Flight flight, int seatRow, int seatCol) {
        boolean[][] seat = flight.getAirplane().getSeats();
        if (seat[seatRow][seatCol]) {
            return false;
        }

        return true;
    }

    public int getSeatCol(String seat) {
        char c = seat.charAt(seat.length() - 1);
        return c - 'A';
    }

    public int getSeatNo(String seat) {
        int seatNo = 0;
        for (int i = 0; i < seat.length(); i++) {
            boolean flag = true;
            char currChar = seat.charAt(i);
            if (Character.isDigit(currChar)) {
                seatNo = seatNo * 10 + (currChar - '0');
                flag = false;
            } else if (flag) {
                break;
            }
        }
        return seatNo;
    }

    public boolean checkDuplicatePassenger(Flight flight, int passengerId) {
        return flight.getPassengerList().stream()
                .anyMatch(passenger -> passenger.getPassengerId() == passengerId);
    }

    public Flight getFlighById(int flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId)
                return flight;
        }
        return null;
    }

    public LocalDateTime getParsedDateTime(String date, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate parsedLocalDate = LocalDate.parse(date, formatter);

        LocalTime parsedLocalTime = LocalTime.parse(time);

        LocalDateTime combinedDateTime = parsedLocalDate.atTime(parsedLocalTime);

        return combinedDateTime;
    }

    public List<Flight> getAvailableFlights(String from, String to, LocalDateTime dateTime) {
        return flights.stream()
                .filter(flight -> flight.getDepartureLocation().equals(from.toLowerCase())
                        && flight.getArrivalLocation().equals(to.toLowerCase()))
                // .peek(flight -> System.out.println("Matching route: " + flight.getDate() +
                // " isAfter? " + flight.getDate().isAfter(dateTime)))
                .filter(flight -> !flight.getDate().isBefore(dateTime))
                .collect(Collectors.toList());
    }

    public void showSeatLayout(int flightId) {
        Flight flight = getFlighById(flightId);
        System.out.println(flight.getAirplane().getModelName() + " Seat Layouts");
        boolean[][] seats = flight.getAirplane().getSeats();
        int economicStart = 1;
        int economicEnd = 8;
        int businessStart = 9;
        int businessEnd = 16;
        int firstStart = 17;
        int firstEnd = 24;
        // To find economic,business,first
        Airplane airplane = flight.getAirplane();
        for (int i = 0; i < seats.length; i++) {
            int seatNo = (i + 1);
            if (airplane.isEconomicClass(seatNo)) {
                economicEnd = seatNo;
                businessStart = economicEnd + 1;
            } else if (airplane.isBusinessClass(seatNo)) {
                businessEnd = seatNo;
                firstStart = businessEnd + 1;
            } else {
                firstEnd = seatNo;
            }
        }
        System.out.println("Economic (" + economicStart + "-" + economicEnd + ")");
        System.out.println("Business (" + businessStart + "-" + businessEnd + ")");
        System.out.println("First (" + firstStart + "-" + firstEnd + ")");
        for (int i = 0; i < seats.length; i++) {
            System.out.print("   " + (i + 1));
        }
        System.out.println();
        for (int col = 0; col < seats[0].length; col++) {
            System.out.print((char) (col + 'A') + "  ");
            for (int row = 0; row < seats.length; row++) {
                System.out.print(seats[row][col] ? "X" : " " + "   ");
            }
            System.out.println();
        }
    }
}

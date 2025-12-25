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
        Flight flight = new Flight(flightId, airplane, departureLocation, arrivalLocation, date, new ArrayList<>());
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
        if (!checkFlightSeatAvail(flight, seatRow, seatCol)) {
            System.out.println(seatNo + " Seat is Already Reserved");
            return null;
        }

        boolean[][] seat = flight.getAirplane().getSeats();
        seat[seatRow][seatCol]=true;
        flight.getPassengerList().add(passenger);
        passenger.setBookedFlight(flight);
        Ticket ticket = new Ticket(passenger,flight,LocalDateTime.now(),"Sucess");
        tickets.add(ticket);
        System.out.println("Flight Booked Successfully");
        return ticket;

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
                seatNo = seatNo * 10 + currChar - '0';
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

    public LocalDateTime getParsedDateTime(String date,String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                
        LocalDate parsedLocalDate = LocalDate.parse(date, formatter);

        LocalTime parsedLocalTime = LocalTime.parse(time);

        LocalDateTime combinedDateTime  = parsedLocalDate.atTime(parsedLocalTime);

        return combinedDateTime;
    }

    public List<Flight> getAvailableFlights(String from, String to, LocalDateTime date) {
        return flights.stream()
                .filter(flight -> flight.getDepartureLocation().equals(from.toLowerCase())
                        && flight.getArrivalLocation().equals(to.toLowerCase()))
                .filter(flight -> flight.getDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public void showSeatLayout(int flightId){
        Flight flight = getFlighById(flightId);
        System.out.println(flight.getAirplane().getModelName() + " Seat Layouts");
        boolean[][] seats = flight.getAirplane().getSeats(); 
        for(int col=0;col<=seats[0].length;col++){
            for(int row=0;row<=seats.length;row++){
                if(row==0 && col==0){
                    continue;
                }
                if(col==0 && row!=0){
                    System.out.println(row+"  ");
                }
                if(row==0 && col!=0){
                    System.out.print((col-1)+'A');
                    System.out.println("  ");
                }
                else {
                    System.out.println(seats[col-1][row-1]+"  ");
                }
            }
        }
    }
}

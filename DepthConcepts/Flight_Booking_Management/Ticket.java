// package Flight_Booking_Management;

import java.time.LocalDateTime;

enum Status {
    ACTIVE, NOT_ACTIVE
}

public class Ticket {
    private static int counter = 0;
    private int ticketNo;

    private Passenger passenger;
    private Flight flight;
    private LocalDateTime dateTime;
    private String seatNo;
    private Status status;

    public Ticket(Passenger passenger, Flight flight, LocalDateTime dateTime, String seatNo, Status status) {
        ticketNo = ++counter;
        this.passenger = passenger;
        this.flight = flight;
        this.dateTime = dateTime;
        this.seatNo = seatNo;
        this.status = status;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "\n============= TICKET DETAILS =============\n" +
                "Ticket Id      : " + ticketNo + "\n"+
                "Passenger Name : " + passenger.getName() + "\n" +
                "Passenger ID   : " + passenger.getPassengerId() + "\n" +
                "Flight ID      : " + flight.getFlightId() + "\n" +
                "From           : " + flight.getDepartureLocation() + "\n" +
                "To             : " + flight.getArrivalLocation() + "\n" +
                "Journey Date   : " + flight.getDate() + "\n" +
                "Booked On      : " + dateTime + "\n" +
                "Status         : " + status + "\n" +
                "Seat Number    : " + seatNo + "\n" +
                "==========================================\n";
    }
}

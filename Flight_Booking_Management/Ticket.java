package Flight_Booking_Management;

import java.time.LocalDateTime;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private LocalDateTime dateTime;
    public String status;

    public Ticket(Passenger passenger, Flight flight, LocalDateTime dateTime, String status) {
        this.passenger = passenger;
        this.flight = flight;
        this.dateTime = dateTime;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

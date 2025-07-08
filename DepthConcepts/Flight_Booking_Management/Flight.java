package Flight_Booking_Management;

import java.util.*;
import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private Airplane airplane;
    private String departureLocation;
    private String arrivalLocation;
    private LocalDateTime date;
    private List<Passenger> passengerList;

    public Flight(int flightId, Airplane airplane, String departureLocation, String arrivalLocation, LocalDateTime date,
            List<Passenger> passengerList) {
        this.flightId = flightId;
        this.airplane = airplane;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.date = date;
        this.passengerList = passengerList;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public int getAvailableSeats(){
        boolean[][] seats = airplane.getSeats();
        int m = seats.length;
        int n = seats[0].length;
        int availableSeats = m*n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(seats[i][j])
                    availableSeats-=1;
            }
        }
        return availableSeats;
    }



}

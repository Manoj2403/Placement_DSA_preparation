// package Flight_Booking_Management;

public class Passenger {
    private static int counter;
    private int passengerId;
    private String name;
    private int age;
    private long contactNo;
    private Flight bookedFlight;

    Passenger(){
        passengerId = ++counter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public void setBookedFlight(Flight bookedFlight) {
        this.bookedFlight = bookedFlight;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getContactNo() {
        return contactNo;
    }

    public Flight getBookedFlight() {
        return bookedFlight;
    }

}

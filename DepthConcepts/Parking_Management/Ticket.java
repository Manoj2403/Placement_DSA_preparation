enum TicketStatus {
    ACTIVE,
    PAID
}

public class Ticket {
    private static int ticketCounter = 1;
    private int ticketNo;
    private Vehicle vehicle;
    private String customerName;
    private long customerPhone;
    private ParkingArea parkingArea;
    private Payment paymentMethod;
    private TicketStatus ticketStatus;

    public Ticket(Vehicle vehicle, ParkingArea parkingArea, String customerName, long customerPhone) {
        this.ticketNo = ticketCounter++;
        this.vehicle = vehicle;
        this.parkingArea = parkingArea;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.ticketStatus = TicketStatus.ACTIVE;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingArea getParkingArea() {
        return parkingArea;
    }

    public String getCustomerName() {
        return customerName;
    }

    public long getCustomerPhone() {
        return customerPhone;
    }

    public double getFare() {
        return vehicle.calculateFee();
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean canMakePayment() {
        return this.ticketStatus == TicketStatus.ACTIVE;
    }

    public void markPaid(Payment paymentMethod, int exitTime) {
        if (!canMakePayment()) {
            System.out.println("Payment cannot be processed for ticket number: " + this.ticketNo + " as its status is: "
                    + this.ticketStatus);
            return;
        }
        this.ticketStatus = TicketStatus.PAID;
        this.paymentMethod = paymentMethod;

        vehicle.setExitTime(exitTime);

        double fee = vehicle.calculateFee();
        System.out.println("Amount to be Paid : " + fee);

        if (paymentMethod.processPayment(fee)) {
            System.out.println("Payment Done Successfully.");
            parkingArea.removeVehicle(vehicle);
        } else {
            System.out.println("Payment Failed. Please try again.");
        }
    }


}

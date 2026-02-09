import java.util.*;

public class ParkingManagement {
    public static void printTicket(Ticket ticket) {
        System.out.println("========================================");
        System.out.println("         PARKING TICKET");
        System.out.println("========================================");
        System.out.println("Ticket No       : " + ticket.getTicketNo());
        System.out.println("Customer Name   : " + ticket.getCustomerName());
        System.out.println("Customer Phone  : " + ticket.getCustomerPhone());
        System.out.println("----------------------------------------");
        System.out.println("Vehicle Details:");
        System.out.println("  Type          : " + ticket.getVehicle().getClass().getSimpleName());
        System.out.println("  Number        : " + ticket.getVehicle().getVehicleNo());
        System.out.println("----------------------------------------");
        System.out.println("Entry Time      : " + ticket.getVehicle().getEntryTime());
        System.out.println("----------------------------------------");
        System.out.println("Status          : " + ticket.getTicketStatus());

        if (ticket.getPaymentMethod() != null) {
            System.out.println("Payment Method  : " + ticket.getPaymentMethod().getClass().getSimpleName());
        }

        System.out.println("========================================");
    }

    public static void main(String[] args) throws Exception {
        List<Ticket> ticketList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the SSM Parking Area.");
        System.out.println("   CAR .  BIKE  .  TRUCK");
        System.out.println("-------------------------");
        // ParkingArea bikeParkingArea = ;
        // ParkingArea carParkingArea = new CarParkingArea(50);
        // ParkingArea truckParkingArea = new TruckParkingArea(25);
        HashMap<String,ParkingArea> parkingAreaMap = new HashMap<>();
        parkingAreaMap.put("bike",new BikeParkingArea(30));
        parkingAreaMap.put("car",new CarParkingArea(50));
        parkingAreaMap.put("truck",new TruckParkingArea(25));

        while (true) {
            System.out.println("1) Park Vehicle\n2) Get Vehicle\n3) View Available Slots\n4) Exit");
            System.out.println("Enter you Choice: ");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                throw new Exception("Enter Valid Number");
            }

            if (choice == 1) {// Park Vehicle
                // get Vehicle Details
                System.out.println("1) Bike\n2) Car\n3) Truck");
                System.out.println("Enter Vehicle Type : ");
                int vehicleChoice = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Vehicle Number : ");
                String vehicleNo = sc.nextLine();
                System.out.println("Enter Vehicle Brand : ");
                String brand = sc.nextLine();
                System.out.println("Enter Vehicle Driver  Name : ");
                String driverName = sc.nextLine();
                System.out.println("Enter the Entry Time : ");
                int entryTime = sc.nextInt();
                System.out.println("Enter Mobile Number : ");
                long mobileNo = sc.nextLong();
                sc.nextLine();
                Vehicle vehicle = null;
                if (vehicleChoice == 1) {// Bike
                    ParkingArea bikeParkingArea = parkingAreaMap.get("bike");
                    if (bikeParkingArea.isFull()) {
                        System.out.println("Bike Parking Area is Full.");
                        continue;
                    }
                    vehicle = new Bike(vehicleNo, brand, driverName, entryTime);
                    if (bikeParkingArea.parkVehicle(vehicle)) {
                        System.out.println("Bike Parked Successfully.");
                        Ticket ticket = new Ticket(vehicle, bikeParkingArea, driverName, mobileNo);
                        ticketList.add(ticket);
                        printTicket(ticket);
                    }
                } else if (vehicleChoice == 2) {// Car
                    ParkingArea carParkingArea = parkingAreaMap.get("car");
                    if (carParkingArea.isFull()) {
                        System.out.println("Car Parking Area is Full.");
                        continue;
                    }
                    vehicle = new Car(vehicleNo, brand, driverName, entryTime);
                    if (carParkingArea.parkVehicle(vehicle)) {
                        System.out.println("Car Parked Successfully.");
                        Ticket ticket = new Ticket(vehicle, carParkingArea, driverName, mobileNo);
                        ticketList.add(ticket);
                        printTicket(ticket);
                    }
                } else if (vehicleChoice == 3) {// Truck
                    ParkingArea truckParkingArea = parkingAreaMap.get("truck");
                    if (truckParkingArea.isFull()) {
                        System.out.println("Truck Parking Area is Full.");
                        continue;
                    }
                    vehicle = new Truck(vehicleNo, brand, driverName, entryTime);
                    if (truckParkingArea.parkVehicle(vehicle)) {
                        System.out.println("Truck Parked Successfully.");
                        Ticket ticket = new Ticket(vehicle, truckParkingArea, driverName, mobileNo);
                        ticketList.add(ticket);
                        printTicket(ticket);
                    }
                } else {
                    System.err.println("Enter Given Choice alone .");
                    continue;
                }
            } else if (choice == 2) {// Get Vehicle
                System.out.println("Enter the Ticket No : ");
                int ticketNo = sc.nextInt();
                // find ticket from the array list
                Ticket currentTicket = null;
                for (Ticket ticket : ticketList) {
                    if (ticket.getTicketNo() == ticketNo && ticket.getTicketStatus() == TicketStatus.ACTIVE) {
                        currentTicket = ticket;
                    }
                }
                if (currentTicket == null) {
                    System.out.println("***Ticket was Not Found. Kindly give the correc Ticket Number.***");
                    continue;
                }
                System.out.println("Enter Exit time : ");
                int exitTime = sc.nextInt();

                Vehicle vehicle = currentTicket.getVehicle();
                vehicle.setExitTime(exitTime);
                double amount = vehicle.calculateFee();
                System.out.println("Rs."+amount+" to be Paid.");
                // Payment steps
                Payment payment = null;
                while (true) {
                    System.out.println("Enter Payment Mode : ( 1)Card 2)UPI 3)Cash )");
                    int paymentChoice = sc.nextInt();
                    sc.nextLine();
                    if (paymentChoice == 1) {// Card
                        System.out.println("Enter Your Card Number : ");
                        String cardNo = sc.nextLine();
                        System.out.println("Enter Card Holder Name : ");
                        String cardHolderName = sc.nextLine();
                        System.out.println("Enter Expiry Date : ");
                        String expiryDate = sc.nextLine();
                        System.out.println("Enter CVV Number : ");
                        String cvvNo = sc.nextLine();
                        payment = new Card(cardNo, cardHolderName, expiryDate, cvvNo);
                    } else if (paymentChoice == 2) {// UPI
                        System.out.println("Enter Your UPI id : ");
                        String upiId = sc.nextLine();
                        payment = new UPI(upiId);
                    } else if (paymentChoice == 3) {
                        payment = new Cash();
                    }
                    if (payment.processPayment(amount)) {
                        System.out.println("Amount " + amount + " Processed Via " + payment.getClass().getSimpleName());
                        currentTicket.setTicketStatus(TicketStatus.PAID);
                        if(currentTicket.getParkingArea().removeVehicle(vehicle)){
                            System.out.println(vehicle.getVehicleNo()+" vehicle Moved Out Successfully..");
                            System.out.println("    Thank You Visit Again.");
                            break;
                        }
                        else{
                            System.out.println("Vehicle Not Removed.");
                        }

                    } else {
                        System.out.println("Payment Not Done via " + payment.getClass().getSimpleName());
                        System.out.println("**Retry**");
                        continue;
                    }
                }

            } else if (choice == 3) {//Show Available Slots
                for(Map.Entry<String,ParkingArea> entry : parkingAreaMap.entrySet()){
                    System.out.println(entry.getKey().toUpperCase()+" : "+entry.getValue().getAvailableParkingCount());
                }
            } else {
                System.out.println("    Thank You Visit Again.");
                break;
            }
        }
        sc.close();

    }
}

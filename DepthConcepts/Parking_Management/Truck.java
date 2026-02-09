public class Truck extends Vehicle {

    public Truck(String vehicleNo, String vehicleName, String ownerName, int entryTime) {
        super(vehicleNo, vehicleName, ownerName, entryTime);
    }

    @Override
    public double calculateFee() {
        return (exitTime-entryTime)*70;
    }   

}

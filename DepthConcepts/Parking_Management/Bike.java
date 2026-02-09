public class Bike extends Vehicle {

    public Bike(String vehicleNo, String vehicleName, String ownerName, int entryTime) {
        super(vehicleNo, vehicleName, ownerName, entryTime);
    }

    @Override
    public double calculateFee() {
        return (exitTime-entryTime)*20;
    }   

}

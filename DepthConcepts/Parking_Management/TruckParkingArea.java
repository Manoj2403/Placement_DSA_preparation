import java.util.*;

public class TruckParkingArea extends ParkingArea {
    private int truckAreaCounts;
    private List<Vehicle> truckList; // It has own storage needs

    public TruckParkingArea(int truckAreaCounts) {
        this.truckAreaCounts = truckAreaCounts;
        this.truckList = new ArrayList<>();
    }

    public List<Vehicle> getTruckList() {
        return truckList;
    }

    public void setTruckList(ArrayList<Vehicle> truckList) {
        this.truckList = truckList;
    }

    public int getTruckAreaCounts() {
        return truckAreaCounts;
    }

    public void setTruckAreaCounts(int truckAreaCounts) {
        this.truckAreaCounts = truckAreaCounts;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        if (isFull()) {
            return false;
        }
        truckList.add(vehicle);
        truckAreaCounts--;
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        if (truckList.contains(vehicle)) {
            truckList.remove(vehicle);
            truckAreaCounts++;
            return true;
        }
        return false;
    }

    @Override
    public int getAvailableParkingCount() {
        return truckAreaCounts;
    }

    @Override
    public boolean isFull() {
        if (truckAreaCounts <= 0) {
            return true;
        }
        return false;
    }

}

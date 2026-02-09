import java.util.*;

public class BikeParkingArea extends ParkingArea {
    private int bikeAreaCounts;
    private List<Vehicle> bikeList; // It has own storage needs

    public BikeParkingArea(int bikeAreaCounts) {
        this.bikeAreaCounts = bikeAreaCounts;
        this.bikeList = new ArrayList<>();
    }

    public List<Vehicle> getBikeList() {
        return bikeList;
    }

    public void setBikeList(ArrayList<Vehicle> bikeList) {
        this.bikeList = bikeList;
    }

    public int getBikeAreaCounts() {
        return bikeAreaCounts;
    }

    public void setBikeAreaCounts(int bikeAreaCounts) {
        this.bikeAreaCounts = bikeAreaCounts;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        if (isFull()) {
            return false;
        }
        bikeList.add(vehicle);
        bikeAreaCounts--;
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        if (bikeList.contains(vehicle)) {
            bikeList.remove(vehicle);
            bikeAreaCounts++;
            return true;
        }
        return false;
    }

    @Override
    public int getAvailableParkingCount() {
        return bikeAreaCounts;
    }

    @Override
    public boolean isFull() {
        if (bikeAreaCounts <= 0) {
            return true;
        }
        return false;
    }

}

import java.util.*;

public class CarParkingArea extends ParkingArea {
    private int carAreaCounts;
    private List<Vehicle> carList; // It has own storage needs

    public CarParkingArea(int carAreaCounts) {
        this.carAreaCounts = carAreaCounts;
        this.carList = new ArrayList<>();
    }

    public int getCarAreaCounts() {
        return carAreaCounts;
    }

    public List<Vehicle> getCarList() {
        return carList;
    }

    public void setCarList(List<Vehicle> carList) {
        this.carList = carList;
    }

    public void setCarAreaCounts(int carAreaCounts) {
        this.carAreaCounts = carAreaCounts;
    }

    @Override
    public boolean parkVehicle(Vehicle vehicle) {
        if (isFull()) {
            return false;
        }
        carList.add(vehicle);
        carAreaCounts--;
        return true;
    }

    @Override
    public boolean removeVehicle(Vehicle vehicle) {
        if (carList.contains(vehicle)) {
            carList.remove(vehicle);
            carAreaCounts++;
            return true;
        }
        return false;
    }

    @Override
    public int getAvailableParkingCount() {
        return carAreaCounts;
    }

    @Override
    public boolean isFull() {
        if (carAreaCounts <= 0) {
            return true;
        }
        return false;
    }

}

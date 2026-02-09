public abstract class Vehicle {
    private String vehicleNo;
    private String vehicleName;
    private String ownerName;
    protected int entryTime;
    protected int exitTime;

    public Vehicle(String vehicleNo, String vehicleName, String ownerName, int entryTime) {
        this.vehicleNo = vehicleNo;
        this.vehicleName = vehicleName;
        this.ownerName = ownerName;
        this.entryTime = entryTime;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public abstract double calculateFee();

}
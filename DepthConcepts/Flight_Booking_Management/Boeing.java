// package Flight_Booking_Management;

public class Boeing implements Airplane {

    private String modelName = "Boeing B777";
    private boolean[][] seats = new boolean[26][4];
    private boolean isEconomicClassAvailable = true;
    private boolean isBusinessClassAvailable = true;
    private boolean isFirstClassAvailable = true;

    @Override
    public String getModelName() {
        return this.modelName;
    }

    @Override
    public boolean[][] getSeats() {
        return this.seats;
    }

    @Override
    public boolean isEconomicClassAvailable() {
        return this.isEconomicClassAvailable;
    }

    @Override
    public boolean isBusinessClassAvailable() {
        return this.isBusinessClassAvailable;
    }

    @Override
    public boolean isFirstClassAvailable() {
        return this.isFirstClassAvailable;
    }

    @Override
    public boolean isBusinessClass(int seatNoRow) {
        boolean isBusiness = false;
        isBusiness = seatNoRow >= 9 && seatNoRow <= 16;
        return isBusiness;
    }

    @Override
    public boolean isEconomicClass(int seatNoRow) {
        boolean isEconomic = false;
        isEconomic = seatNoRow >= 1 && seatNoRow <= 8;
        return isEconomic;
    }

    @Override
    public boolean isFirstClass(int seatNoRow) {
        boolean isFirst = false;
        isFirst = seatNoRow >= 17 && seatNoRow <= 26;
        return isFirst;
    }

}

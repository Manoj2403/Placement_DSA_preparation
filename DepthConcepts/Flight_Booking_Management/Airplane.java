// package Flight_Booking_Management;

public interface Airplane {
    String getModelName();
    boolean[][] getSeats();
    boolean isEconomicClassAvailable();
    boolean isBusinessClassAvailable();
    boolean isFirstClassAvailable();

    boolean isBusinessClass(int seatNoRow);
    boolean isEconomicClass(int seatNoRow);
    boolean isFirstClass(int seatNoRow);
}

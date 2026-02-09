public class UPI implements Payment {
    private String upiId;

    public String getUpiId() {
        return upiId;
    }

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }

}

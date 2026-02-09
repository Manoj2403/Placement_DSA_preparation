public class Cash implements Payment {
    
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
    
}

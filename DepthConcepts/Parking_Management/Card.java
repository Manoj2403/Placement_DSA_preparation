public class Card implements Payment {
    private String cardNo;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;

    public Card(String cardNo, String cardHolderName, String expiryDate, String cvv) {
        this.cardNo = cardNo;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount) {
        return true;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

}

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expirationDate, String cvv, String number) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public void pay(double amount) {
        // implementation of processing credit card payment
        System.out.println("Credit card payment processed for $" + amount);
    }
}
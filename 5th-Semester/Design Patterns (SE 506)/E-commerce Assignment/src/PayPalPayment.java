public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        // implementation of processing PayPal payment
        System.out.println("PayPal payment processed for $" + amount);
    }
}
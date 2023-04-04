public class CryptocurrencyPayment implements PaymentStrategy {
    private String address;
    private String privateKey;

    public CryptocurrencyPayment(String address, String privateKey, String s) {
        this.address = address;
        this.privateKey = privateKey;
    }

    public void pay(double amount) {
        // implementation of processing cryptocurrency payment
        System.out.println("Cryptocurrency payment processed for $" + amount);
    }
}
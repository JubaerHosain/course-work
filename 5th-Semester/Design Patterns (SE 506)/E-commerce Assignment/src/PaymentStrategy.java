public interface PaymentStrategy {
    void pay(double amount);

    double getAmount(double totalCost);
}
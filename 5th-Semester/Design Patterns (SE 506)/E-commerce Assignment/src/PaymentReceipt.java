import java.util.List;

public class PaymentReceipt {
    private String customerName;
    private String customerEmail;
    private List<Product> items;
    private double totalCost;
    private double discountAmount;
    private double finalAmount;
    private PaymentStrategy paymentMethod;

    public PaymentReceipt(String customerName, String customerEmail, List<Product> items, double totalCost, double discountAmount, double finalAmount, PaymentStrategy paymentMethod) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.items = items;
        this.totalCost = totalCost;
        this.discountAmount = discountAmount;
        this.finalAmount = finalAmount;
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public PaymentStrategy getPaymentMethod() {
        return paymentMethod;
    }

    public void send(String email) {
        // send receipt via email
    }
}
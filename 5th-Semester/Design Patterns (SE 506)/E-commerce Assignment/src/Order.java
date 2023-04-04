import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private ShoppingCart cart;
    private PaymentStrategy paymentMethod;

    public Order(User user, ShoppingCart cart, PaymentStrategy paymentMethod) {
        this.user = user;
        this.cart = cart;
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public PaymentStrategy getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processOrder() {
        double totalCost = cart.calculateTotalCost();
        paymentMethod.pay(totalCost);
    }

    public PaymentReceipt generateReceipt() {
        double totalCost = cart.calculateTotalCost();
        double paymentAmount = paymentMethod.getAmount(totalCost);
        double discountAmount = cart.getDiscountAmount();
        double finalAmount = paymentAmount - discountAmount;
        return new PaymentReceipt(user.getName(), user.getEmail(), cart.getItems(), totalCost, discountAmount, finalAmount, paymentMethod);
    }
}
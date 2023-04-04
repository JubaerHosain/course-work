import java.util.ArrayList;
import java.util.List;

public class EcommerceMediator {
    private List<Product> productList;
    private List<User> userList;
    private List<Payment> paymentList;

    public EcommerceMediator() {
        productList = new ArrayList<>();
        userList = new ArrayList<>();
        paymentList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addPayment(Payment payment) {
        paymentList.add(payment);
    }

    public void processOrder(User user, Product product, Payment payment) {
        if (userList.contains(user) && productList.contains(product) && paymentList.contains(payment)) {
            if (product.getInventory() > 0) {
                product.setInventory(product.getInventory() - 1);
                sendReceipt(user, product, payment);
            } else {
                System.out.println("Sorry, the product is out of stock.");
            }
        } else {
            System.out.println("Invalid user, product, or payment.");
        }
    }

    private void sendReceipt(User user, Product product, Payment payment) {
        // implementation of sending receipt to user
        System.out.println("Order confirmed. Receipt sent to " + user.getEmail());
    }

    public void addPaymentMethod(PaymentStrategy creditCard) {
    }

    public void processOrder(Order order) {
    }
}

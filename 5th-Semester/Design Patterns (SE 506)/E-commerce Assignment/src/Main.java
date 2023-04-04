import java.util.ArrayList;
import java.util.List;

public class Main {
    public static <ShoppingCart> void main(String[] args) {
        // create some example products
        Product p1 = new Product("1234", "iPhone 12", "The latest iPhone model", 999.99, "https://example.com/iphone12.jpg", 10);
        Product p2 = new Product("5678", "Samsung Galaxy S21", "The latest Samsung model", 899.99, "https://example.com/galaxys21.jpg", 5);
        Product p3 = new Product("9101", "Google Pixel 5", "The latest Google phone", 799.99, "https://example.com/pixel5.jpg", 3);

        // create some example users
        User u1 = new User("Alice", "alice@example.com", "password123", "123 Main St, Anytown USA");
        User u2 = new User("Bob", "bob@example.com", "letmein", "456 Elm St, Anytown USA");

        // create some example payment methods
        PaymentStrategy creditCard = new CreditCardPayment("John Smith", "1234 5678 9012 3456", "12/23", "123");
        PaymentStrategy payPal = new PayPalPayment("alice@example.com", "password123");
        PaymentStrategy cryptocurrency = new CryptocurrencyPayment("Bitcoin", "bc1qar0srrr7xfkvy5l643lydnw9re59gtzzwf5mdq", "0.001");
//
//        // create a shopping cart for Alice
        ShoppingCart cart = new ShoppingCart(u1);

        // add some products to the cart
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        // apply a discount to the cart
        DiscountStrategy discount = new PercentageDiscountStrategy(0.1);
        cart.applyDiscount(discount);

        // calculate the total cost of the cart
        double totalCost = cart.calculateTotalCost();

        // create an order for Alice using the credit card payment method
        Order order = new Order(u1, cart, creditCard);

        // process the order
        EcommerceMediator mediator = new EcommerceMediator();
        mediator.addUser(u1);
        mediator.addUser(u2);
        mediator.addProduct(p1);
        mediator.addProduct(p2);
        mediator.addProduct(p3);
        mediator.addPaymentMethod(creditCard);
        mediator.addPaymentMethod(payPal);
        mediator.addPaymentMethod(cryptocurrency);
        mediator.processOrder(order);

        // send a receipt to Alice
        PaymentReceipt receipt = order.generateReceipt();
        receipt.send(u1.getEmail());
    }
}

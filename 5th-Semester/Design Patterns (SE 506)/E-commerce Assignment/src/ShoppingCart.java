import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private User user;
    private List<Product> products;
    private DiscountStrategy discountStrategy;

    public ShoppingCart(User user) {
        this.user = user;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
        if (discountStrategy != null) {
            totalCost = discountStrategy.applyDiscount(totalCost);
        }
        return totalCost;
    }

    public void applyDiscount(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public double getDiscountAmount() {
        return 0;
    }

    public List<Product> getItems() {
        return products;
    }
}

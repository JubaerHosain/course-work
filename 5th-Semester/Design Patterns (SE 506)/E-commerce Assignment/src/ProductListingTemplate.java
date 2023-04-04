import java.util.List;

public abstract class ProductListingTemplate {
    public void displayProductList() {
        System.out.println("Product List:");
        List<Product> products = getProductList();
        for (Product product : products) {
            displayProductDetails(product);
        }
    }

    public void displayProductDetails(Product product) {
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Inventory: " + product.getInventory());
        System.out.println();
    }

    public void addToCart(Product product) {
        System.out.println(product.getName() + " added to cart.");
    }

    public abstract List<Product> getProductList();
}
public class Product {
    private String name;
    private String description;
    private double price;
    private String image;
    private int inventory;

    public Product(String name, String description, String theLatestIPhoneModel, double price, String image, int inventory) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}

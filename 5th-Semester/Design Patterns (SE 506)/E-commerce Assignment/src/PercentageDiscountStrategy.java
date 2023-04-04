public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    public double apply(double price) {
        return price * (1 - percentage);
    }
}
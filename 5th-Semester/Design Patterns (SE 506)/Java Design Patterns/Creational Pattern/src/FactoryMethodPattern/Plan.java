package FactoryMethodPattern;

public abstract class Plan {
    protected double rate;
    public abstract void getRate();

    public double calculateBill(int units) {
        return units * rate;
    }
}
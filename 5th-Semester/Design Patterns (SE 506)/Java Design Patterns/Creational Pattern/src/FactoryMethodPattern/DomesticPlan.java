package FactoryMethodPattern;

public class DomesticPlan extends Plan {
    public DomesticPlan() {
        super();
    }
    @Override
    public void getRate() {
        this.rate = 3.50;
    }
}
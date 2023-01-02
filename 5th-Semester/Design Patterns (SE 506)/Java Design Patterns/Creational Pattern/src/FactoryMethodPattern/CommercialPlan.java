package FactoryMethodPattern;

class  CommercialPlan extends Plan {
    public CommercialPlan() {
        super();
    }
    @Override
    public void getRate() {
        this.rate = 7.50;
    }
}
package FactoryMethodPattern;

class InstitutionalPlan extends Plan {
    public InstitutionalPlan() {
        super();
    }
    //@override
    public void getRate() {
        this.rate = 5.50;
    }
}
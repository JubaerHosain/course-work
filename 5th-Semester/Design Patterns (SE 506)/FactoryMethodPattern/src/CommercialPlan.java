class  CommercialPlan extends Plan {
    public CommercialPlan(double rate) {
        super();
        this.rate = rate;
    }
    @Override
    public void getRate() {
        rate = 7.50;
    }
}
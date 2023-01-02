package AbstractFactoryPattern;

abstract class Loan {
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years) {
        double EMI = years * loanamount * rate;
        System.out.println("Your monthly EMI is "+ EMI +" for the amount "+loanamount+" you have borrowed");
    }
}
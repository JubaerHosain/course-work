package AbstractFactoryPattern;

public class HomeLoan extends Loan{
    public void getInterestRate(double rate){
        this.rate = rate;
    }
}
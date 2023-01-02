package AbstractFactoryPattern;

class LoanFactory extends AbstractFactory {
    public Bank getBank(String bank) {
        return null;
    }


    public Loan getLoan(String loan) {
        if(loan == null){
            return null;
        } else if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        } else if(loan.equalsIgnoreCase("Business")){
            return new BussinessLoan();
        } else if(loan.equalsIgnoreCase("Education")){
            return new EducationLoan();
        }
        return null;
    }
}

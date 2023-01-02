package AbstractFactoryPattern;

class BankFactory extends AbstractFactory{
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        } else if(bank.equalsIgnoreCase("HDFC")){
            return new HDFCBank();
        } else if(bank.equalsIgnoreCase("ICICI")){
            return new ICICIBank();
        } else if(bank.equalsIgnoreCase("SBI")){
            return new SBIBank();
        }
        return null;
    }

    // this is another design problem bcz getLoan is not needed here
    public Loan getLoan(String loan) {
        return null;
    }
}

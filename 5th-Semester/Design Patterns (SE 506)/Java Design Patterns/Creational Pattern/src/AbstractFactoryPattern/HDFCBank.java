package AbstractFactoryPattern;

public class HDFCBank implements Bank {
    private final String bankName;
    public HDFCBank() {
        bankName = "HDFC BANK";
    }


    @Override
    public String getBankName() {
        return this.bankName;
    }
}

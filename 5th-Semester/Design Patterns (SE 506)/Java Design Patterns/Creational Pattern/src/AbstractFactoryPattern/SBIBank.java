package AbstractFactoryPattern;

class SBIBank implements Bank{
    private final String bankName;
    public SBIBank(){
        this.bankName = "SBI BANK";
    }

    @Override
    public String getBankName() {
        return this.bankName;
    }
}
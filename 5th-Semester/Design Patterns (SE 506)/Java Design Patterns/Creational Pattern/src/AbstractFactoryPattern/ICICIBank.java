package AbstractFactoryPattern;

class ICICIBank implements Bank{
    private final String bankName;
    public ICICIBank(){
        this.bankName = "ICICI BANK";
    }


    @Override
    public String getBankName() {
        return this.bankName;
    }
}
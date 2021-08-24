package App;

public class Merchant{

    public String name;
    public String merchantId;
    public BankAccount bankAccount;

    Merchant(String merchantName){
        this.name = merchantName;
        this.merchantId = (int)(Math.random()*1000) + "";
        this.bankAccount = new BankAccount(merchantName);
    }

}

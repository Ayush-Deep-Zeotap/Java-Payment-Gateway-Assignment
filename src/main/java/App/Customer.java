package App;

public class Customer {

    public String name;
    public String phoneNo;
    public PayTMWallet payTMWallet;
    public PhonePeWallet phonePeWallet;
    public BankAccount bankAccount;

    Customer(String customerName,String ph,int newBal){
        this.name = customerName;
        this.phoneNo = ph;
        this.phonePeWallet = new PhonePeWallet(ph,newBal);
        this.payTMWallet = new PayTMWallet(ph,newBal);
        this.bankAccount = new BankAccount(customerName,newBal);
    }

    Customer(String customerName){
        this.name = customerName;
    }

    Customer(String customerName,int initialBal){
        this.name = customerName;
        this.bankAccount = new BankAccount(customerName,initialBal);
    }

}

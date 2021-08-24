package App;


public class BankAccount {

    public String accountNumber;
    public String accountHolder;
    public int bal;

    BankAccount(String name){
        this.accountHolder = name;
        this.accountNumber = (int)(Math.round(Math.random()*2000.)) + "";
        this.bal = 0;
    }

    BankAccount(String name,int intialAmt){
        this.accountHolder = name;
        this.accountNumber = (int)(Math.round(Math.random()*2000.)) + "";
        this.bal = intialAmt;
    }
}

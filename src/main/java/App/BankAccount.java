package App;

import java.time.LocalDate;

public class BankAccount {

    public int accountNumber;
    public String accountHolder;
    public int bal;

    BankAccount(AuthService auth,String name){
        this.accountHolder = name;
        this.accountNumber = auth.registeredBankAccounts.size() + 1;
        this.bal = 0;
    }
}

package App;

import java.util.ArrayList;

class InvalidMerchantException  extends Exception
{
    public InvalidMerchantException (String str)
    {
        super(str);
    }
}

class OutOfSufficientFundsException extends  Exception{

    public OutOfSufficientFundsException(String str){
        super(str);
    }
}

public class AuthService {

    public ArrayList<String> registeredMerchants;

    AuthService(){
        this.registeredMerchants = new ArrayList<String>();
    }

    void register(Merchant merchant){
        registeredMerchants.add(merchant.merchantId);
    }

    boolean checkValidity(PhonePeWallet phonePeWallet){
       return (phonePeWallet != null);
    }

    boolean checkValidity(PayTMWallet payTMWallet){
        return (payTMWallet != null);
    }

    boolean checkAuthenicity(Merchant merchant){
        return registeredMerchants.contains(merchant.merchantId);
    }

    boolean checkValidity(BankAccount bankAccount){
        return bankAccount != null;
    }

    void payTMTransaction(PayTMWallet payTMWallet,Merchant merchant,int amount) throws OutOfSufficientFundsException {
        if(checkValidity(payTMWallet)){
            if(payTMWallet.bal >= amount){
                payTMWallet.bal -= amount;
                merchant.bankAccount.bal += amount;
                System.out.println("Transaction Completed Successfully");
            }else throw new OutOfSufficientFundsException("You do not have the sufficient funds in your wallet");

        }else throw new NullPointerException("Not a registered  PayTMWallet");
    }

    void phonePeTransaction(PhonePeWallet phonePeWallet,Merchant merchant,int amount) throws OutOfSufficientFundsException {
        if(checkValidity(phonePeWallet)){
            if(phonePeWallet.bal >= amount){
                phonePeWallet.bal -= amount;
                merchant.bankAccount.bal += amount;
                System.out.println("Transaction Completed Successfully");
            }else throw new OutOfSufficientFundsException("You do not have the sufficient funds in your wallet");

        }else throw new NullPointerException("Not a registered  PhonePeWallet");
    }

    void bankTransaction(BankAccount bankAccount,Merchant merchant,int amount) throws OutOfSufficientFundsException {
        if(checkValidity(bankAccount)){
            if(bankAccount.bal >= amount){
                bankAccount.bal -= amount;
                merchant.bankAccount.bal += amount;
                System.out.println("Transaction Completed Successfully");
            }else throw new OutOfSufficientFundsException("You do not have the sufficient funds in your wallet");

        }else throw new NullPointerException("Not a registered Bank Account");
    }


    void transaction(Customer customer, Merchant merchant, String choosen, int amount) throws InvalidMerchantException, OutOfSufficientFundsException {
        if(checkAuthenicity(merchant)){

            switch(choosen){
                case "PAYTM":
                    payTMTransaction(customer.payTMWallet,merchant,amount);
                    break;
                case "PHONEPE":
                    phonePeTransaction(customer.phonePeWallet,merchant,amount);
                    break;
                case "CARD":
                    bankTransaction(customer.bankAccount,merchant,amount);
                    break;
                default:
                    throw new IllegalArgumentException("Not a valid wallet/Card choice");
            }

        }else throw new InvalidMerchantException("Not an Authentic Merchant");
    }


}

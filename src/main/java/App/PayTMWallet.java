package App;

public class PayTMWallet {

    public String phoneNo;
    public int bal;

    PayTMWallet(String ph,int amt){
        this.phoneNo = ph;
        this.bal = amt;
    }

    PayTMWallet(String ph){
        this.phoneNo = ph;
        this.bal = 0;
    }

}

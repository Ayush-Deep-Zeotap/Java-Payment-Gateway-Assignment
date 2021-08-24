package App;

public class PhonePeWallet {

    public String phoneNo;
    public int bal;

    PhonePeWallet(String ph,int intialAmt){
        this.phoneNo = ph;
        this.bal = intialAmt;
    }

    PhonePeWallet(String ph){
        this.phoneNo = ph;
        this.bal = 0;
    }
}

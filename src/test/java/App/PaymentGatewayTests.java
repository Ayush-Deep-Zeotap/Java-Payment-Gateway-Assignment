package App;

import org.junit.Before;
import org.junit.Test;

public class PaymentGatewayTests {

    AuthService authService = null;
    Customer C1 = null ;
    Customer C2 = null;
    Customer C3 = null;
    Customer C4 = null;
    Merchant M1 = null;
    Merchant M2 = null;

    @Before
    public void setup(){

        C1 = new Customer("C1");
        C2 = new Customer("C2",1000);
        C3 = new Customer("C3","22082208",500);
        C4 = new Customer("C4",400);
        M1 = new Merchant("M1");
        M2 = new Merchant("M2");
        authService = new AuthService();
        authService.register(M2);
    }

    @Test(expected = InvalidMerchantException.class)
    public void testMerchant() throws InvalidMerchantException, OutOfSufficientFundsException {
        authService.transaction(C1,M1,"CARD",200);
        authService.transaction(C2,M1,"CARD",200);
    }

    @Test(expected = OutOfSufficientFundsException.class)
    public void testBalanceCheck() throws OutOfSufficientFundsException, InvalidMerchantException {
        authService.transaction(C3,M2,"CARD",1000);
        authService.transaction(C4,M2,"CARD",1000);
    }

    @Test(expected = NullPointerException.class)
    public void testWalletValidity() throws InvalidMerchantException, OutOfSufficientFundsException {
        authService.transaction(C1,M2,"PAYTM",100);
        authService.transaction(C1,M2,"PHONEPE",100);
        authService.transaction(C2,M2,"PAYTM",100);
        authService.transaction(C2,M2,"PHONEPE",100);
        authService.transaction(C4,M2,"PAYTM",100);
        authService.transaction(C4,M2,"PHONEPE",100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidPaymentMethod() throws IllegalArgumentException, InvalidMerchantException, OutOfSufficientFundsException {
        authService.transaction(C3,M2,"XYZ",100);
    }

}

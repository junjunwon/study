package payment.implement;

import payment.PayableInterface;

public class CreditCardPayment implements PayableInterface {

    @Override
    public String pay() {
        //카드 결제 프로세스
        return "Pay By CreditCard";
    }
}

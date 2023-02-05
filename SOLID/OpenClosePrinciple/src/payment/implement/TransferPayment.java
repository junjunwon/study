package payment.implement;

import payment.PayableInterface;

public class TransferPayment implements PayableInterface {

    @Override
    public String pay() {
        //무통장 결제 프로세스
        return "Pay By Cash";
    }
}

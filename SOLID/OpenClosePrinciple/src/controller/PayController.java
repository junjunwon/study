package controller;

import request.PayRequest;
import payment.PaymentFactory;

public class PayController {

    private PaymentFactory factory = new PaymentFactory();

    public String payControl(PayRequest payRequest) throws Exception {
        String payResult = factory.initializePayment(payRequest.getType()).pay();
        return payResult;
    }
}

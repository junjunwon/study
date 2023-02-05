package payment;

import payment.implement.CreditCardPayment;
import payment.implement.TransferPayment;

public class PaymentFactory {

    public PayableInterface initializePayment (String type) throws Exception {
        if (type == "credit") {
            return new CreditCardPayment();
        } else if (type == "transfer") {
            return new TransferPayment();
        }

        throw new Exception("Unsupported payment method");
    }
}

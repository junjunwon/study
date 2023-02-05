package wrongWay.domain;

import java.math.BigDecimal;

public class FixedTermDepositAccount extends Account {
    @Override
    public String deposit(BigDecimal amount) {
        return "Thank you for deposit";
    }

    @Override
    public String withdraw() {
        throw new UnsupportedOperationException("Withdraw does not supported for this type of Account");
    }
}

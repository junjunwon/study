package wrongWay.domain;

import java.math.BigDecimal;

public class WithdrawableAccount extends Account {
    @Override
    public String deposit(BigDecimal amount) {
        return "success for deposit";
    }

    @Override
    public String withdraw() {
        return "this is able to withdraw for this type of account";
    }
}

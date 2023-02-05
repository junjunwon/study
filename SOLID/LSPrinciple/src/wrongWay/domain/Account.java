package wrongWay.domain;

import java.math.BigDecimal;

public abstract class Account {
    protected abstract String deposit(BigDecimal amount);
    protected abstract String withdraw();
}

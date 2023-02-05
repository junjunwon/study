package wrongWay.service;

import wrongWay.domain.Account;
import wrongWay.domain.FixedTermDepositAccount;
import wrongWay.domain.WithdrawableAccount;

public class BankingService {

    public String goodRequestwithdraw() {

        WithdrawableAccount withdrawableAccount = new WithdrawableAccount();
        return withdrawableAccount.withdraw();
    }
    public void badRequestwithdraw() {

        FixedTermDepositAccount fixedTermDepositAccount = new FixedTermDepositAccount();
        fixedTermDepositAccount.withdraw();
    }
}

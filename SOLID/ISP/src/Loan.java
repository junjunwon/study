public interface Loan extends Payment {
    void initiateLoanSettlement();
    void initiateRepayment();
}

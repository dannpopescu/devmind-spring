package ro.devbank.domain.bankaccounts;

public class CreditBankAccount extends BankAccount {

    private double limitAmount;

    public CreditBankAccount(long ownerId, double limitAmount) {
        super(ownerId);
        this.limitAmount = limitAmount;
    }
}

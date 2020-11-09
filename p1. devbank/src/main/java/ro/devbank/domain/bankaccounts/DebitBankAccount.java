package ro.devbank.domain.bankaccounts;

public class DebitBankAccount extends BankAccount {

    private String IBAN;

    public DebitBankAccount(long ownerId, String IBAN) {
        super(ownerId);
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }
}

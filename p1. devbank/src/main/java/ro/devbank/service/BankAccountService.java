package ro.devbank.service;

import ro.devbank.domain.bankaccounts.CreditBankAccount;
import ro.devbank.domain.bankaccounts.DebitBankAccount;
import ro.devbank.domain.users.Client;
import ro.devbank.repository.BankAccountRepository;

public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    private static final String ACCOUNT_IBAN_PREFIX = "RODEVBANK00DEBIT";

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public DebitBankAccount createDebitBankAccount(long ownerId) {
        String iban = String.format("%s%5d", ACCOUNT_IBAN_PREFIX, (int) (Math.random() * 5));
        DebitBankAccount account = new DebitBankAccount(ownerId, iban);
        return bankAccountRepository.save(account);
    }

    public CreditBankAccount createCreditBankAccount(long ownerId, double limitAmount) {
        CreditBankAccount account = new CreditBankAccount(ownerId, limitAmount);
        return account;
    }

    public void transfer(long fromAccountId, String toIban, double amount) {

    }

    public void transferToIBAN(DebitBankAccount fromAccount, String toIBAN, double amount) {
        DebitBankAccount toAccount = bankAccountRepository.findDebitAccountByIBAN(toIBAN);
        if (toAccount == null) {
            throw new IllegalArgumentException("No bank account with the given IBAN");
        }
        fromAccount.debit(amount);
        toAccount.credit(amount);
    }

    public boolean ibanExists(String iban) {
        return bankAccountRepository.existsByIban(iban);
    }

}

package ro.devbank.repository;

import ro.devbank.domain.bankaccounts.BankAccount;
import ro.devbank.domain.bankaccounts.DebitBankAccount;

import java.util.HashMap;

public class BankAccountRepository {

    private final HashMap<String, DebitBankAccount> debitAccounts = new HashMap<>();

    private static long BANK_ACCOUNT_ID_SEQUENCE = 0;

    public DebitBankAccount findDebitAccountByIBAN(String IBAN) {
        return debitAccounts.get(IBAN);
    }

    public DebitBankAccount save(DebitBankAccount account) {
        account.setId(++BANK_ACCOUNT_ID_SEQUENCE);
        debitAccounts.put(account.getIBAN(), account);
        return account;
    }

    public boolean existsByIban(String iban) {
        return debitAccounts.containsKey(iban);
    }
}

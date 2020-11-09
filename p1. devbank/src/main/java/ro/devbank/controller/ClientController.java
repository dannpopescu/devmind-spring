package ro.devbank.controller;

import ro.devbank.domain.Transaction;
import ro.devbank.domain.bankaccounts.BankAccount;
import ro.devbank.domain.users.Client;
import ro.devbank.service.BankAccountService;
import ro.devbank.service.ClientService;

import java.util.ArrayList;
import java.util.List;

public class ClientController {

    private final ClientService clientService;
    private final BankAccountService bankAccountService;

    public ClientController(ClientService clientService, BankAccountService bankAccountService) {
        this.clientService = clientService;
        this.bankAccountService = bankAccountService;
    }

    public List<BankAccount> getAllAccountsForClient(String username) {
        return clientService.getAllAccountsForClient(username);
    }

    public double getAccountBalance(String username, long accountId) {
        return clientService.getAccountBalance(username, accountId);
    }

    public boolean transferToIBAN(String username, long accountId, String iban, double amount) {
        return false;
    }

    public boolean transferToPersonalAccount(String username, long fromAccountId, long toAccountId, double amount) {
        return false;
    }

    public boolean payCreditAccountDebt(String username, long debitAccountId, long creditAccountId, double amount) {
        return false;
    }

    public List<Transaction> getAllTransactionsForAccount(String username, long accountId) {
        return new ArrayList<>();
    }
}

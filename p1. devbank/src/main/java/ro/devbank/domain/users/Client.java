package ro.devbank.domain.users;

import ro.devbank.domain.bankaccounts.BankAccount;
import ro.devbank.domain.bankaccounts.DebitBankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Client {

    private long id;
    private String username;
    private String password;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addBankAccount(BankAccount bankAccount) {
        this.bankAccounts.add(bankAccount);
    }

    public boolean hasAccountWithId(long accountId) {
        return bankAccounts.stream().mapToLong(BankAccount::getId).anyMatch(id -> id == accountId);
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }
}

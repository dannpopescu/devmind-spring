package ro.devbank.domain.bankaccounts;

public class BankAccount {

    private long id;
    private double balance;
    private long ownerId;

    public BankAccount(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        balance -= amount;
    }
}

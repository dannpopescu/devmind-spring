package ro.devbank.service;

import ro.devbank.domain.bankaccounts.BankAccount;
import ro.devbank.domain.bankaccounts.DebitBankAccount;
import ro.devbank.domain.users.Client;
import ro.devbank.exception.EntityNotFoundException;
import ro.devbank.repository.UserRepository;

import java.util.List;

public class ClientService {

    private final UserRepository userRepository;
    private final BankAccountService bankAccountService;

    public ClientService(UserRepository userRepository, BankAccountService bankAccountService) {
        this.userRepository = userRepository;
        this.bankAccountService = bankAccountService;
    }

    public List<BankAccount> getAllAccountsForClient(String username) {
        Client client = getClient(username);
        return client.getBankAccounts();
    }

    public double getAccountBalance(String username, long accountId) {
        Client client = getClient(username);
        client.hasAccountWithId(accountId);
        return 0;
    }

    private Client getClient(String username) {
        Client client = userRepository.findClientByUsername(username);
        if (client == null) {
            throw new EntityNotFoundException("Client not found with username = " + username);
        }
        return client;
    }


}

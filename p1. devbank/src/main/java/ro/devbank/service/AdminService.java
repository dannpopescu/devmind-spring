package ro.devbank.service;

import ro.devbank.domain.users.Client;
import ro.devbank.domain.users.LegalPerson;
import ro.devbank.domain.users.NaturalPerson;
import ro.devbank.repository.BankAccountRepository;
import ro.devbank.repository.UserRepository;

public class AdminService {

    private final UserRepository userRepository;
    private final BankAccountService bankAccountService;
    private final BankAccountRepository bankAccountRepository;

    public AdminService(UserRepository userRepository, BankAccountService bankAccountService, BankAccountRepository bankAccountRepository) {
        this.userRepository = userRepository;
        this.bankAccountService = bankAccountService;
        this.bankAccountRepository = bankAccountRepository;
    }

    public LegalPerson createLegalPerson(String username, String password, String companyName, String CUI, int capital, double transactionCost) {
        LegalPerson legalPerson = new LegalPerson(username, password, companyName, CUI, capital, transactionCost);
        return userRepository.saveClient(legalPerson);
    }

    public NaturalPerson createNaturalPerson(String username, String password, String firstName, String lastName, String CNP) {
        NaturalPerson naturalPerson = new NaturalPerson(username, password, firstName, lastName, CNP);
        return userRepository.saveClient(naturalPerson);
    }

    public void createDebitBankAccount(String clientUsername) {
        Client client = userRepository.findClientByUsername(clientUsername);
        bankAccountService.createDebitBankAccount(client.getId());
    }

    public void createCreditBankAccount(String clientUsername, double limitAmount) {
        Client client = userRepository.findClientByUsername(clientUsername);
        validateLimitAmount(client, limitAmount);
        bankAccountService.createCreditBankAccount(client.getId(), limitAmount);
    }

    public void validateLimitAmount(Client client, double limitAmount) {
        if (client instanceof NaturalPerson) {
            NaturalPerson naturalPerson = (NaturalPerson) client;
            if (limitAmount > naturalPerson.getSalary()) {
                throw new IllegalArgumentException();
            }
        } else if (client instanceof LegalPerson) {
            LegalPerson legalPerson = (LegalPerson) client;
            if (limitAmount * 0.1 > legalPerson.getCapital()) {
                throw new IllegalArgumentException();
            }
        }
    }
}

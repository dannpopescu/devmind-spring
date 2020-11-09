package ro.devbank.controller;

import ro.devbank.Response;
import ro.devbank.domain.users.LegalPerson;
import ro.devbank.domain.users.NaturalPerson;
import ro.devbank.service.AdminService;

public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    public Response<LegalPerson> createLegalPerson(String username, String password, String companyName, String CUI, int capital, double transactionCost) {
        LegalPerson legalPerson = adminService.createLegalPerson(username, password, companyName, CUI, capital, transactionCost);
        return new Response<>(legalPerson);
    }

    public Response<NaturalPerson> createNaturalPerson(String username, String password, String firstName, String lastName, String CNP) {
        NaturalPerson naturalPerson = adminService.createNaturalPerson(username, password, firstName, lastName, CNP);
        return new Response<>(naturalPerson);
    }

    public void createDebitBankAccount(String clientUsername) {
        adminService.createDebitBankAccount(clientUsername);
    }

    public void createCreditBankAccount(String clientUsername, double limitAmount) {
        adminService.createCreditBankAccount(clientUsername, limitAmount);
    }
}

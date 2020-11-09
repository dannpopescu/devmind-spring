package ro.devbank.controller;

import ro.devbank.Response;
import ro.devbank.domain.users.Admin;
import ro.devbank.domain.users.Client;
import ro.devbank.service.LoginService;

public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public Response<Client> loginClient(String username, String password) {
        if (!loginService.existsClientByUsername(username)) {
            return new Response<>("Username not found");
        }
        Client client = loginService.loginClient(username, password);
        if (client == null) {
            return new Response<>("Incorrect password");
        }
        return new Response<>(client);
    }

    public Response<Admin> loginAdmin(String username, String password) {
        if (!loginService.existsAdminByUsername(username)) {
            return new Response<>("Username not found");
        }
        Admin admin = loginService.loginAdmin(username, password);
        if (admin == null) {
            return new Response<>("Incorrect password");
        }
        return new Response<>(admin);
    }
}

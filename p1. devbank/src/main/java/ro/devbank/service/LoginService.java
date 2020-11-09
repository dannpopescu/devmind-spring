package ro.devbank.service;

import ro.devbank.domain.users.Admin;
import ro.devbank.domain.users.Client;
import ro.devbank.repository.UserRepository;

public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Client loginClient(String username, String password) {
        Client client = userRepository.findClientByUsername(username);
        if (!client.getPassword().equals(password)) {
            return null;
        }
        return client;
    }

    public boolean existsClientByUsername(String username) {
        return userRepository.existsClientByUsername(username);
    }

    public Admin loginAdmin(String username, String password) {
        Admin admin = userRepository.findAdminByUsername(username);
        if (!admin.getPassword().equals(password)) {
            return null;
        }
        return admin;
    }


    public boolean existsAdminByUsername(String username) {
        return userRepository.existsAdminByUsername(username);
    }
}

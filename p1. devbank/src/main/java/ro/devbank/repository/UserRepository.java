package ro.devbank.repository;

import ro.devbank.domain.users.Admin;
import ro.devbank.domain.users.Client;
import ro.devbank.domain.users.LegalPerson;

import java.util.HashMap;

public class UserRepository {

    private final HashMap<String, Client> clients = new HashMap<>();
    private final HashMap<String, Admin> admins = new HashMap<>();

    private static long CLIENT_ID_SEQUENCE = 0;

    public Client findClientByUsername(String username) {
        return clients.get(username);
    }

    public boolean existsClientByUsername(String username) {
        return clients.containsKey(username);
    }

    public Admin findAdminByUsername(String username) {
        return admins.get(username);
    }

    public boolean existsAdminByUsername(String username) {
        return admins.containsKey(username);
    }

    public <T extends Client> T saveClient(T entity) {
        entity.setId(++CLIENT_ID_SEQUENCE);
        clients.put(entity.getUsername(), entity);
        return entity;
    }
}

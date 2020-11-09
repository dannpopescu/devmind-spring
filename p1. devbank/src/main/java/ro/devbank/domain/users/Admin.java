package ro.devbank.domain.users;

public class Admin {

    private long id;
    private String username;
    private String password;

    public Admin(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

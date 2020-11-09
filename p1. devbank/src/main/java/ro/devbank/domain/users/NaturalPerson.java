package ro.devbank.domain.users;

public class NaturalPerson extends Client {

    private String firstName;
    private String lastName;
    private String CNP;
    private int salary;

    public NaturalPerson(String username, String password, String firstName, String lastName, String CNP) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

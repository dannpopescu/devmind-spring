package ro.devbank.domain.users;

public class LegalPerson extends Client {

    private String companyName;
    private String CUI;
    private int capital;
    private double transactionCost;

    public LegalPerson(String username, String password, String companyName, String CUI, int capital, double transactionCost) {
        super(username, password);
        this.companyName = companyName;
        this.CUI = CUI;
        this.capital = capital;
        this.transactionCost = transactionCost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public double getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(double transactionCost) {
        this.transactionCost = transactionCost;
    }
}

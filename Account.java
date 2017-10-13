package RMI;

public class Account {
    Double balance = 0.0;
    String name;

    public Account(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package RMI;

import java.util.ArrayList;

public class BankImp implements Bank {
    Account logged_in = null;
    ArrayList<Account> accounts = new ArrayList<>();
    public BankImp() {}

    @Override
    public Boolean deposit(Double amount) {
        if(logged_in!=null) {
            logged_in.setBalance(logged_in.getBalance()+amount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean withdraw(Double amount) {
        if(logged_in!=null) {
            if(logged_in.getBalance()-amount<0) {
                return false;
            } else {
                logged_in.setBalance(logged_in.getBalance()-amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public Double balance() {
        if(logged_in!=null) return logged_in.getBalance();
        return null;
    }

    @Override
    public Boolean login(String name) {
        for(Account a:accounts) {
            if(name.equals(a.getName())) {
                logged_in = a;
                return true;
            }
        }
        return false;
    }

    public void add_account(Account account) {
        accounts.add(account);
    }
}

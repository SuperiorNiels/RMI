package RMI;

import java.util.ArrayList;

public class BankImp implements Bank {
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Account> logged_in = new ArrayList<>();
    public BankImp() {}

    @Override
    public Boolean deposit(String name, Double amount) {
        Account a = get_account(name);
        if(logged_in.contains(a) && a!=null) {
            a.setBalance(a.getBalance()+amount);
            return true;
        }
        return false;
    }

    @Override
    public Boolean withdraw(String name, Double amount) {
        Account a = get_account(name);
        if(logged_in.contains(a) && a!=null) {
            if(a.getBalance()-amount<0) {
                return false;
            } else {
                a.setBalance(a.getBalance()-amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public Double balance(String name) {
        Account a = get_account(name);
        if(logged_in.contains(a) && a!=null) return a.getBalance();
        return null;
    }

    @Override
    public Boolean login(String name) {
        Account a = get_account(name);
        Boolean res = (a!=null) ? true : false;
        if(res) logged_in.add(a);
        return res;
    }

    public void add_account(Account account) {
        accounts.add(account);
    }

    public Account get_account(String name) {
        for(Account a:accounts) {
            if(name.equals(a.getName())) {
                return a;
            }
        }
        return null;
    }

    //TODO: implement remove_account and logout methods
}

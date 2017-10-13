package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public Client() {}

    public void connect() {
        String name = null;
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.1.148");
            Bank stub = (Bank) registry.lookup("Bank");
            Scanner input = new Scanner(System.in);
            Boolean valid_account = false;
            while(valid_account == false) {
                System.out.print("Login name: ");
                name = input.nextLine();
                valid_account = (stub.login(name)) ? true : false;
            }
            Boolean logged_in = true;
            while(logged_in) {
                System.out.print("> ");
                String command = input.nextLine();
                String[] parts = command.split(" ");
                if(parts[0].equals("withdraw")) {
                    if(parts.length > 1) {
                        if(stub.withdraw(name, Double.parseDouble(parts[1]))) {
                            System.out.println("Withdraw succesfull.");
                        } else {
                            System.out.println("Withdraw failed.");
                        }
                    } else {
                        System.out.println("Please enter amount as parameter.");
                    }
                }
                else if(parts[0].equals("deposit")) {
                    if(parts.length > 1) {
                        if(stub.deposit(name, Double.parseDouble(parts[1]))) {
                            System.out.println("Deposit succesfull.");
                        } else {
                            System.out.println("Deposit failed.");
                        }
                    } else {
                        System.out.println("Please enter amount as parameter.");
                    }
                }
                else if(parts[0].equals("balance")) {
                    System.out.println("Your balance: "+stub.balance(name));
                }
                else if(parts[0].equals("exit")) {
                    logged_in = false;
                }
                else if(parts[0].equals("help")) {
                    System.out.println("Commands:");
                    System.out.println("\twithdraw <amount>");
                    System.out.println("\tdeposit <amount>");
                    System.out.println("\tbalance");
                    System.out.println("\texit");
                }
                else {
                    System.out.println("Not a valid command.\nType 'help' for a list of commands.");
                }
            }
            System.out.println("Exit");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

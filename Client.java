package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public Client() {}

    public void connect() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            Bank stub = (Bank) registry.lookup("Bank");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            stub.login(name);
            System.out.println("response:");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server() {}

    public void run() {
        try {
            BankObject bank = new BankObject();
            Bank stub = (Bank) UnicastRemoteObject.exportObject(bank,0);
            Registry registry = LocateRegistry.getRegistry(5000);
            registry.bind("Bank", stub);
            System.out.println("Server started.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

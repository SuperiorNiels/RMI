package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    BankImp bank;
    public Server(BankImp bank) {
        this.bank = bank;
    }

    public void run() {
        try {
            Bank stub = (Bank) UnicastRemoteObject.exportObject(bank,0);
            Registry registry = LocateRegistry.getRegistry("192.168.1.148");
            registry.bind("Bank", stub);
            System.out.println("Server started.");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

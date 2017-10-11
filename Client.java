package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {}

    public void connect() {
        try {
            Registry registry = LocateRegistry.getRegistry(5000);
            Bank stub = (Bank) registry.lookup("Bank");
            System.out.println("response:"+stub.sayHello());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankObject implements Bank {
    public BankObject() {}

    @Override
    public String sayHello() throws RemoteException {
        return "Hello world!";
    }
}

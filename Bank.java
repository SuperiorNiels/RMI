package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    String sayHello() throws RemoteException;
}

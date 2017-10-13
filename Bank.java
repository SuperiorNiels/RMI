package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    Boolean deposit(Double amount) throws RemoteException;;
    Boolean withdraw(Double amount) throws RemoteException;;
    Double balance() throws RemoteException;;
    Boolean login(String name) throws RemoteException;;
}

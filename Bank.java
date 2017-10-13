package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bank extends Remote {
    Boolean deposit(String name, Double amount) throws RemoteException;;
    Boolean withdraw(String name, Double amount) throws RemoteException;;
    Double balance(String name) throws RemoteException;;
    Boolean login(String name) throws RemoteException;;
}

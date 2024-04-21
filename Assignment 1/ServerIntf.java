import java.rmi.*;

// Define the remote interface ServerIntf which extends Remote interface
interface ServerIntf extends Remote {

    // Declare remote methods that can be invoked by clients
    public double add(double a, double b) throws RemoteException;

    public double sub(double a, double b) throws RemoteException;

    public double div(double a, double b) throws RemoteException;

    public double mul(double a, double b) throws RemoteException;
}

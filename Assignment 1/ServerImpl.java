import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    public ServerImpl() throws RemoteException {
    }

    // Implementation of the remote 'add' method
    public double add(double a, double b) throws RemoteException {
        return a + b;
    }

    // Implementation of the remote 'sub' method
    public double sub(double a, double b) throws RemoteException {
        return a - b;
    }

    // Implementation of the remote 'div' method
    public double div(double a, double b) throws RemoteException {
        return a / b;
    }

    // Implementation of the remote 'mul' method
    public double mul(double a, double b) throws RemoteException {
        if (b == 0)
            return 0;
        return a * b;
    }
}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {

    public ClientImpl() throws RemoteException {
        super();
    }

    @Override
    public void alert(String message) throws RemoteException {
        System.out.println("Alerte reçue : " + message);
    }
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

    void alert(String message) throws RemoteException;
}

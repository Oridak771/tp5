import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface StockInterface extends Remote {

    Map<String, Integer> getStock() throws RemoteException;

    void addToStock(String productName, int quantity) throws RemoteException;

    void removeFromStock(String productName, int quantity) throws RemoteException;

    void registerClient(ClientInterface client) throws RemoteException;

    void unregisterClient(ClientInterface client) throws RemoteException;
}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockImpl extends UnicastRemoteObject implements StockInterface {

    private Map<String, Integer> stock;
    private List<ClientInterface> clients;

    public StockImpl() throws RemoteException {
        super();
        this.stock = new HashMap<String, Integer>();
        this.clients = new ArrayList<ClientInterface>();
    }

    @Override
    public Map<String, Integer> getStock() throws RemoteException {
        return this.stock;
    }

    @Override
    public void addToStock(String productName, int quantity) throws RemoteException {
        int currentQuantity = this.stock.getOrDefault(productName, 0);
        this.stock.put(productName, currentQuantity + quantity);
        this.notifyClients(productName + " a été ajouté au stock avec une quantité de " + quantity);
    }

    @Override
    public void removeFromStock(String productName, int quantity) throws RemoteException {
        int currentQuantity = this.stock.getOrDefault(productName, 0);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity < 0) {
            newQuantity = 0;
        }
        this.stock.put(productName, newQuantity);
        this.notifyClients(productName + " a été retiré du stock avec une quantité de " + quantity);
    }

    @Override
    public void registerClient(ClientInterface client) throws RemoteException {
        this.clients.add(client);
    }

    @Override
    public void unregisterClient(ClientInterface client) throws RemoteException {
        this.clients.remove(client);
    }

    private void notifyClients(String message) throws RemoteException {
        for (ClientInterface client : this.clients) {
            client.alert(message);
        }
    }
}

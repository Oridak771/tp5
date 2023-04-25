import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        StockInterface stock = new StockImpl();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("Stock", stock);
        System.out.println("Serveur prêt !");
    }
}

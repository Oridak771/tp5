import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Map;

public class Client
{   public static void main(String[] args) throws RemoteException {
        try {
            StockInterface stock = (StockInterface) Naming.lookup("rmi://localhost/Stock");
            ClientInterface client = new ClientImpl();
            stock.registerClient(client);
            System.out.println("Client enregistré !");
            Map<String, Integer> currentStock = stock.getStock();
            System.out.println("Stock actuel : " + currentStock);
            stock.addToStock("Produit A", 10);
            stock.removeFromStock("Produit B", 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
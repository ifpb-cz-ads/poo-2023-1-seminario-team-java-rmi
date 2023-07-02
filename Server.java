import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            Estoque lojaObj = new Estoque();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.bind("LojaObj", lojaObj);

            System.out.println("Servidor RMI iniciado!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
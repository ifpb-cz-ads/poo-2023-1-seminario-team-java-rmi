import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // Cria uma instância do objeto remoto
            Estoque lojaObj = new Estoque();
            // Inicia o registro RMI na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            // Vincula o objeto remoto ao registro RMI com um nome específico
            registry.bind("LojaObj", lojaObj);

            System.out.println("Servidor RMI iniciado!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
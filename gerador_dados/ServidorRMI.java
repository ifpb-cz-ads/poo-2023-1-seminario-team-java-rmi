package gerador_dados;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class ServidorRMI {
    public static void main(String[] args) {
        try{
            IPessoa dados = new GeradorDeDados();
            String objnome = "rmi://localhost/dados";

            System.out.println("registrando o objeto no RMIRegistry...");
            LocateRegistry.createRegistry(1099);
            Naming.rebind(objnome, dados);
            System.out.println("aguardando cliente!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

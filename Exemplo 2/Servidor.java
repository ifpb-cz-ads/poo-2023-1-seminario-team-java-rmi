import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args)  {
       
        try {
        Geometricos geometricos = new Geometricos();
        String localizacao = "rmi/localhost/geo";
        System.out.println("Registro o objeto no RMIRegistry ");
        LocateRegistry.createRegistry(1099);
        Naming.rebind(localizacao, geometricos);

        System.out.println("Aguardando Cliente!");
        }catch(Exception ex){
            System.out.println(" Erro: "+ ex.getMessage());

        }
    }
}

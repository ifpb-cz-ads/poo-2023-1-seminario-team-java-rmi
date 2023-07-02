import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry();

            Loja lojaObj = (Loja) registry.lookup("LojaObj");

            int codigo = 1;

            String nome = lojaObj.NomeItem(codigo);
            int estoque = lojaObj.EstoqueItem(codigo);
            double preco = lojaObj.PrecoItem(codigo);

            System.out.println("Nome do item: " + nome);
            System.out.println("Estoque do item: " + estoque);
            System.out.println("Preço do item: " + preco);

            int estoquenovo = 5;
            lojaObj.alterarEstoqueItem(codigo, estoquenovo);

            estoque = lojaObj.EstoqueItem(codigo);
            System.out.println("Estoque atualizado: " + estoque);

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
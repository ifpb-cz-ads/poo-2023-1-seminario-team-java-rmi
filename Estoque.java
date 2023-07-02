import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Estoque extends UnicastRemoteObject implements Loja {
    private Map<Integer, String> nome;
    private Map<Integer, Integer> estoque;
    private Map<Integer, Double> preco;

    public Estoque() throws RemoteException {
        nome = new HashMap<>();
        estoque = new HashMap<>();
        preco = new HashMap<>();

        nome.put(1, "Iphone X");
        estoque.put(1, 10);
        preco.put(1, 3999.99);
    }
    
    public String NomeItem(int codigo) throws RemoteException {
        return nome.getOrDefault(codigo, "Produto não encontrado");
    }

    public int EstoqueItem(int codigo) throws RemoteException {
        return estoque.getOrDefault(codigo, 0);
    }

    public double PrecoItem(int codigo) throws RemoteException {
        return preco.getOrDefault(codigo, 0.0);
    }
    public void alterarEstoqueItem(int codigo, int quantidade) throws RemoteException {
        estoque.put(codigo, quantidade);
        System.out.println(" Estoque do item: " + codigo + " atualizado para: " + quantidade);
    }
}
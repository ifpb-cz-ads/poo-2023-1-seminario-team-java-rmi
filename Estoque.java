import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque extends UnicastRemoteObject implements Loja {
    private Map<Integer, String> nome;
    private Map<Integer, Integer> estoque;
    private Map<Integer, Double> preco;
    private Map<String, List<Integer>> produtosPorCategoria;

    public Estoque() throws RemoteException {
        nome = new HashMap<>();
        estoque = new HashMap<>();
        preco = new HashMap<>();
        produtosPorCategoria = new HashMap<>();

        /*nome.put(1, "Iphone X");
        estoque.put(1, 10);
        preco.put(1, 3999.99);*/
        adicionarItem(1, "Iphone X", 10, 3000.99, "Celular");
        adicionarItem(2, "Iphone 13", 5, 5000.99, "Celular");
        adicionarItem(3, "Iphone 13 Pro Max", 8, 5999.99, "Celular");
        adicionarItem(4, "Macbook", 15, 9800.99, "PC");

    }

    private void adicionarItem(int codigo, String item, int estoqueInicial, double precoInicial, String categoria) {
        nome.put(codigo, item);
        estoque.put(codigo, estoqueInicial);
        preco.put(codigo, precoInicial);

        List<Integer> produtos = produtosPorCategoria.getOrDefault(categoria, new ArrayList<>());
        produtos.add(codigo);
        produtosPorCategoria.put(categoria, produtos);
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
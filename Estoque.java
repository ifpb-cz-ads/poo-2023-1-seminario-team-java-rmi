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
    private List<Integer> carrinho;

    public Estoque() throws RemoteException {
        nome = new HashMap<>();
        estoque = new HashMap<>();
        preco = new HashMap<>();
        produtosPorCategoria = new HashMap<>();
        carrinho = new ArrayList<>();

        /*nome.put(1, "Iphone X");
        estoque.put(1, 10);
        preco.put(1, 3999.99);*/
        // Inicializar alguns itens de exemplo
        // Adicionar itens da categoria "Headset Gamer"
        adicionarItem(1, "Headset Gamer Redragon Zeus X", 10, 279.99, "Headset Gamer");
        adicionarItem(2, "Headset Gamer HyperX Cloud", 5, 189.99, "Headset Gamer");
        adicionarItem(3, "Headset Gamer JBL Quantum 400", 5, 279.99, "Headset Gamer");
        adicionarItem(4, "Headset Gamer Corsair HS50", 8, 199.99, "Headset Gamer");
        adicionarItem(5, "Headset Gamer Logitech G Pro X", 3, 349.99, "Headset Gamer");

        // Adicionar itens da categoria "Mouse Gamer"
        adicionarItem(6, "Mouse Gamer Redragon Cobra", 5, 89.99, "Mouse Gamer");
        adicionarItem(7, "Mouse Gamer Logitech G502", 8, 149.99, "Mouse Gamer");
        adicionarItem(8, "Mouse Gamer Razer DeathAdder Elite", 3, 199.99, "Mouse Gamer");
        adicionarItem(9, "Mouse Gamer SteelSeries Rival 600", 5, 219.99, "Mouse Gamer");

        // Adicionar itens da categoria "Teclado Gamer"
        adicionarItem(10, "Teclado Gamer Redragon Kumara", 10, 149.99, "Teclado Gamer");
        adicionarItem(11, "Teclado Gamer Corsair K70", 5, 299.99, "Teclado Gamer");
        adicionarItem(12, "Teclado Gamer HyperX Alloy Elite", 8, 249.99, "Teclado Gamer");
        adicionarItem(13, "Teclado Gamer Razer Huntsman Elite", 3, 499.99, "Teclado Gamer");

        // Adicionar itens da categoria "Fone de ouvido Gamer"
        adicionarItem(14, "Fone de ouvido Gamer HyperX Cloud Stinger", 10, 149.99, "Fone de ouvido Gamer");
        adicionarItem(15, "Fone de ouvido Gamer Razer Kraken", 5, 299.99, "Fone de ouvido Gamer");
        adicionarItem(16, "Fone de ouvido Gamer SteelSeries Arctis 7", 8, 599.99, "Fone de ouvido Gamer");
        adicionarItem(17, "Fone de ouvido Gamer Logitech G Pro", 3, 699.99, "Fone de ouvido Gamer");

        // Adicionar itens da categoria "Streamer"
        adicionarItem(18, "Microfone Condensador USB Fifine", 10, 199.99, "Streamer");
        adicionarItem(19, "Câmera de Streaming Logitech C920", 5, 399.99, "Streamer");
        adicionarItem(20, "Placa de Captura Elgato Game Capture HD60 Pro", 8, 999.99, "Streamer");
        adicionarItem(21, "Anel de Luz LED para Stream Neewer", 3, 199.99, "Streamer");

        // Adicionar itens da categoria "Mouse pad"
        adicionarItem(22, "Mouse pad HyperX Fury", 10, 49.99, "Mouse pad");
        adicionarItem(23, "Mouse pad Razer Goliathus", 5, 79.99, "Mouse pad");
        adicionarItem(24, "Mouse pad SteelSeries QcK", 8, 99.99, "Mouse pad");
        adicionarItem(25, "Mouse pad Corsair MM300", 3, 129.99, "Mouse pad");

        // Adicionar itens da categoria "Webcam"
        adicionarItem(26, "Webcam Logitech C270", 10, 129.99, "Webcam");
        adicionarItem(27, "Webcam Microsoft LifeCam HD-3000", 5, 99.99, "Webcam");
        adicionarItem(28, "Webcam Razer Kiyo", 8, 299.99, "Webcam");
        adicionarItem(29, "Webcam Sony FDR-AX43", 3, 699.99, "Webcam");

        // Adicionar itens da categoria "Kit Gamer"
        adicionarItem(30, "Kit Gamer Redragon S101", 10, 299.99, "Kit Gamer");
        adicionarItem(31, "Kit Gamer HyperX Alloy Origins Core", 5, 599.99, "Kit Gamer");
        adicionarItem(32, "Kit Gamer Corsair K95 Platinum", 8, 999.99, "Kit Gamer");
        adicionarItem(33, "Kit Gamer Razer Huntsman Elite + Razer Viper Ultimate", 3, 1499.99, "Kit Gamer");
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
    public List<String> obterCategorias() throws RemoteException {
        return new ArrayList<>(produtosPorCategoria.keySet());
    }

    public List<Integer> obterProdutosPorCategoria(String categoria) throws RemoteException {
        return produtosPorCategoria.getOrDefault(categoria, new ArrayList<>());
    }

    public List<String> obterNomesProdutosPorCategoria(String categoria) throws RemoteException {
        List<Integer> produtos = produtosPorCategoria.getOrDefault(categoria, new ArrayList<>());
        List<String> nomesProdutos = new ArrayList<>();
        for (int codigo : produtos) {
            nomesProdutos.add(nome.getOrDefault(codigo, "Produto não encontrado"));
        }
        return nomesProdutos;
    }

    public void adicionarItemAoCarrinho(int codigo) throws RemoteException {
        carrinho.add(codigo);
        System.out.println("Produto " + codigo + " adicionado ao carrinho.");
    }

    public List<Integer> obterItensCarrinho() throws RemoteException {
        return new ArrayList<>(carrinho);
    }

}
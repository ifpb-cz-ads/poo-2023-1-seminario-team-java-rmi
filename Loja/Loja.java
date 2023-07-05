import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Loja extends Remote {
    String NomeItem(int codigo) throws RemoteException;
    int EstoqueItem(int codigo) throws RemoteException;
    double PrecoItem(int codigo) throws RemoteException;
    void alterarEstoqueItem(int codigo, int quantidade) throws RemoteException;
    List<String> obterCategorias() throws RemoteException;
    List<Integer> obterProdutosPorCategoria(String categoria) throws RemoteException;
    List<String> obterNomesProdutosPorCategoria(String categoria) throws RemoteException;
    void adicionarItemAoCarrinho(int codigo) throws RemoteException;
    List<Integer> obterItensCarrinho() throws RemoteException;
}
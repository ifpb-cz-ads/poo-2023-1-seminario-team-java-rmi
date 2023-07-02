import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Loja extends Remote {
    String NomeItem(int codigo) throws RemoteException;
    int EstoqueItem(int codigo) throws RemoteException;
    double PrecoItem(int codigo) throws RemoteException;
    void alterarEstoqueItem(int codigo, int quantidade) throws RemoteException;
}
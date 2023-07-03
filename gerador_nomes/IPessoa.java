package gerador_nomes;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPessoa extends Remote{

    public String gerarNome() throws
    RemoteException;
    
    public byte gerarIdade()  throws RemoteException;
    
    public String gerarProfissao() throws RemoteException;

    public String gerarMotivoExpulsao() throws RemoteException;

}
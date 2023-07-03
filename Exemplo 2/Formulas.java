import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Formulas extends Remote {
    public double Retangulo(double base,double altura) throws RemoteException;
    public double Quadrado(double lado) throws RemoteException;
    public double Circulo(double raio) throws RemoteException;

}
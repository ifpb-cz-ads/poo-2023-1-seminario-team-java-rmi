import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Formulas extends Remote {
    public double Retangulo(double base,double altura) throws RemoteException;
    public double Quadrado(double lado) throws RemoteException;
    public double Circulo(double raio) throws RemoteException;
    public double CalcularAd(double num1, double num2) throws RemoteException;
    public double CalcularDiv(double num3, double num4) throws RemoteException;
    public double CalcularSub(double num5, double num6) throws RemoteException;
}
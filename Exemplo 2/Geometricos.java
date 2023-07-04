import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Geometricos extends  UnicastRemoteObject implements Formulas {

    protected Geometricos() throws RemoteException {
        super();
        System.out.println("Novo Servidor instanciado...");
    }

    @Override
    public double Retangulo(double base, double altura) throws RemoteException {
         return (base*altura);
    }

    @Override
    public double Quadrado(double lado) throws RemoteException {
        return (lado*lado);
    }

    @Override
    public double Circulo(double raio) throws RemoteException {
        return (raio*raio)*3.14;
    }

    
    @Override
    public double CalcularAd(double num1, double num2) throws RemoteException{
        return (num1+num2);
    }
    
    @Override
    public double CalcularDiv(double num3, double num4) throws RemoteException{
        return (num3/num4);
    }
    
    @Override
    public double CalcularSub(double num5, double num6) throws RemoteException{
        return (num5-num6);
    }
    
}

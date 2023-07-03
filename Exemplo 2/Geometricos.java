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
    
}

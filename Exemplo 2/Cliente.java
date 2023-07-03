import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
            String nomeObjeto = "rmi/localhost/geo";

            Formulas formulas = (Formulas) Naming.lookup(nomeObjeto);

            System.out.println("O primeiro numeros que voce deseja:");
            double numero1 = sc.nextDouble();

            System.out.println("Os segundo que voce deseja:");
            double numero2 = sc.nextDouble();

            System.out.println("O Resultado da perimetro é Retangulo: " + formulas.Retangulo(numero1, numero2));
            System.out.println("O Resultado da perimetro é Quadrado: " + numero1 + " " + formulas.Quadrado(numero1));
            System.out.println("O Resultado da perimetro é Circulo: " + numero1 + " " + formulas.Circulo(numero1));

            sc.close();
        }
    
}

import java.rmi.Naming;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
            String nomeObjeto = "rmi/localhost/geo";

            Formulas formulas = (Formulas) Naming.lookup(nomeObjeto);


            System.out.println("Calcular a Area do Retangulo: digite 1");
            System.out.println("Calcular a Area do Quadrado: digite 2");
            System.out.println("Calcular a Area de uma Cicuferencia: digite 3");
            System.out.println("Sair: digite 4");
            int opcao = 0;
            while ( opcao != 4){
            System.out.println("O numero que voce deseja: ");
             opcao = sc.nextInt();
            switch (opcao) {
                case 1 :
                System.out.print("O primeiro numeros que voce deseja:");
                double numero1 = sc.nextDouble();
                System.out.print("O primeiro numeros que voce deseja:");
                double numero2 = sc.nextDouble();
                System.out.println("O Resultado da Area é Retangulo: " + formulas.Retangulo(numero1, numero2));
                break;
                case 2:
                System.out.print("O primeiro numeros que voce deseja:");
                double lado = sc.nextDouble();
                System.out.println("O Resultado da Area é Quadrado: "  + formulas.Quadrado(lado));
                break;
                case 3:
                System.out.print("O primeiro numeros que voce deseja:");
                double raio = sc.nextDouble();
                System.out.println("O Resultado da Area é Circulo: " + formulas.Circulo(raio));
                break;
                case 4: 
                System.out.println("obrigador !!!");
                break;
                default:
                System.out.println("invalido");
            }

            }
            sc.close();
        }
    
}

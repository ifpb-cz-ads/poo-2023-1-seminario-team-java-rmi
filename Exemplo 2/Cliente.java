import java.rmi.Naming;

public class Cliente {
    public static void main(String[] args) throws Exception{
            String nomeObjeto = "rmi/localhost/geo";

            Formulas formulas = (Formulas) Naming.lookup(nomeObjeto);

            System.out.println("O Resultado da soma é: " + formulas.Circulo(5));
        }
    
}

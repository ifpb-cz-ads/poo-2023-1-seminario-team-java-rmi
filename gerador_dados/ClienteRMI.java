package gerador_dados;

import java.rmi.Naming;
import java.util.Scanner;



public class ClienteRMI {
    public static void main(String[] args)  throws Exception{
        String objNome = "rmi://localhost/dados";
        IPessoa pessoa = (IPessoa) Naming.lookup(objNome);

        Scanner sc = new Scanner(System.in);

        boolean menu = true;

        while(menu){
            
            System.out.println("selecione uma opção");
            System.out.println("1 - gerar nova pessoa");
            System.out.println("2 - encerrar o programa\n");
            byte opcao = sc.nextByte();

            switch(opcao){
                case 1:
                    System.out.println("-------------------------------------------");
                    System.out.println("nome: "+pessoa.gerarNome());
                    System.out.println("idade: "+pessoa.gerarIdade());
                    System.out.println("profissão "+pessoa.gerarProfissao());
                    System.out.println("---------------------------------------------");

                break;

                case 2:
                    
                    System.out.println("obrigada por usar o programa");
                    menu = false;
                    break;

                
            }


        }
        
       

    }
}
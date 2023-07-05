package gerador_dados;

import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;



public class ClienteRMI2 {
    public static void main(String[] args)  throws Exception{
        String objNome = "rmi://localhost/dados";
        IPessoa pessoa = (IPessoa) Naming.lookup(objNome);


        Scanner sc = new Scanner(System.in);

        boolean menu = true;

        while(menu){
            
            System.out.println("selecione uma opção");
            System.out.println("1 - prever o futuro de alguem");
            System.out.println("2 - encerrar o programa\n");
            byte opcao = sc.nextByte();

            switch(opcao){
                case 1:
                    
                    Random num = new Random();
                    System.out.println("-------------------------------------------");
                    System.out.println("nome: "+pessoa.gerarNome());
                    System.out.println("profissão "+pessoa.gerarProfissao());
                    if (num.nextInt(10) <= 5 ){
                        System.out.println("foi expulso(a), pelo motivo de: "+pessoa.gerarMotivoExpulsao());
                    }
                    else{
                        System.out.println("não foi expulso(a)");
                    }
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
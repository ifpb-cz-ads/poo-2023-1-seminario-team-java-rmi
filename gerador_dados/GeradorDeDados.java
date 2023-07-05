package gerador_dados;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Random;


public class GeradorDeDados extends UnicastRemoteObject implements IPessoa {
    
    protected GeradorDeDados() throws RemoteException {
        super();
    }



    String[] nomes = {"Mauricio Bernardo","Gabriella Braga","Maria Clara","Douglas da Silva","Vinícius da Silva","João Darwin","Felipe David","Joyciane de Azevedo","Danrlei de Lira", "Eduardo Dênis", "Joyce dos Santos","Damiana Ernesto","Hermes Feitoza","Debora Fernandes", "Jose Gabriel","Tobias Galdino","Flavio Henrique","Nícolas Jessé","Antonio Lacerda","Karl Lenin","Marianna Lopes","Andre Lucas","Antonio Marcos","Wanderson Matheus","Marcos Paulo","Joao Pedro","Verissimo Pereira","Diogo Santana ","Jose Vieira","Lucio Weslley"};

    String[] profissoes = {"Dev","desempregado(a)","professor(a)"};

    String[] motivos = {"chamou um professor de comunista","escreveu algo no mural dos direitos humanos","praticou crimes de odio na frente de wellington","roubou ketchup da cantina e deu calote em cicero","quebrou cadeira","usou var em vez de let na disciplina de linguagem de script","foi pra aula de fabio sem animação","usou a camisa do mr.robot"};
    


    Random gerador = new Random();



    public String gerarNome() throws RemoteException{

        int indice = gerador.nextInt(nomes.length);

        String nome = nomes[indice];

        return nome;

    }
    public byte gerarIdade()  throws RemoteException{
        
        byte idade = (byte) gerador.nextInt(80);

        return idade;
    }
    
    
    
    public String gerarProfissao() throws RemoteException{

        int indice = gerador.nextInt(profissoes.length);

        String profissao = profissoes[indice];

        return profissao;
    }

    public String gerarMotivoExpulsao() throws RemoteException{

        int indice = gerador.nextInt(motivos.length);

        String motivo = motivos[indice];

        return motivo;

    }

}
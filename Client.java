import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {
    private static Loja lojaObj;
    public static void main(String[] args) {
        try {
            // Localiza o registro RMI na máquina local
            Registry registry = LocateRegistry.getRegistry();
            // Obtém a referência para o objeto remoto do registro RMI
            lojaObj = (Loja) registry.lookup("LojaObj");
            exibirMenuPrincipal();

        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
    private static void exibirMenuPrincipal() throws RemoteException {
        System.out.println("===== Bem-vindo à Loja Online =====");
        System.out.println("Selecione uma opção:");
        System.out.println("1. Categorias");
        System.out.println("2. Carrinho");
        System.out.println("0. Sair");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirMenuCategorias();
                break;
            case 2:
                exibirCarrinho();
                break;
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                exibirMenuPrincipal();
                break;
        }
    }

    private static void exibirMenuCategorias() throws RemoteException {
        List<String> categorias = lojaObj.obterCategorias();

        System.out.println("===== Categorias =====");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }
        System.out.println("0. Voltar");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao >= 1 && opcao <= categorias.size()) {
            String categoria = categorias.get(opcao - 1);
            exibirItensCategoria(categoria);
        } else if (opcao == 0) {
            exibirMenuPrincipal();
        } else {
            System.out.println("Opção inválida!");
            exibirMenuCategorias();
        }
    }

    private static void exibirItensCategoria(String categoria) throws RemoteException {
        List<Integer> produtos = lojaObj.obterProdutosPorCategoria(categoria);
        List<String> nomesProdutos = lojaObj.obterNomesProdutosPorCategoria(categoria);

        System.out.println("===== " + categoria + " =====");
        for (int i = 0; i < produtos.size(); i++) {
            int codigo = produtos.get(i);
            String nome = nomesProdutos.get(i);
            System.out.println((i + 1) + ". " + nome + " (Codigo: " + codigo + ")");
        }
        System.out.println("0. Voltar");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao >= 1 && opcao <= produtos.size()) {
            int codigo = produtos.get(opcao - 1);
            adicionarItemAoCarrinho(codigo);
            exibirItensCategoria(categoria);
        } else if (opcao == 0) {
            exibirMenuCategorias();
        } else {
            System.out.println("Opção inválida!");
            exibirItensCategoria(categoria);
        }
    }

    private static void adicionarItemAoCarrinho(int codigo) throws RemoteException {
        lojaObj.adicionarItemAoCarrinho(codigo);
        System.out.println("Item adicionado ao carrinho!");
    }

    private static void exibirCarrinho() throws RemoteException {
        List<Integer> itensCarrinho = lojaObj.obterItensCarrinho();

        System.out.println("===== Carrinho =====");
        for (int codigo : itensCarrinho) {
            String nome = lojaObj.NomeItem(codigo);
            System.out.println("Item: " + nome + " (Código: " + codigo + ")");
        }
        System.out.println("0. Voltar");

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao == 0) {
            exibirMenuPrincipal();
        } else {
            System.out.println("Opção inválida!");
            exibirCarrinho();
        }
    }
}
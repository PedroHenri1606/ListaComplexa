package dao;

import model.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {


    public List<Produto> cadastrar(List<Produto> produtos){

        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.print  (" Informe o nome: "); String nome = scan.nextLine();
        System.out.print  (" Informe o tipo do produto: "); String tipo = scan.nextLine();
        System.out.print  (" Informe o valor: "); Long valor = scan.nextLong();
        System.out.println("--------------------------------------------------");

        produtos.add(new Produto(nome,tipo.toUpperCase(),valor));
        return produtos;
    }

    public void editar(List<Produto> produtos){

        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        this.listar(produtos);
        System.out.print("Escolha o ID: "); int escolha = scan.nextInt();

        Produto produto = produtos.get(escolha);

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Editar Nome                       ");
            System.out.println("          [2] - Editar Tipo                       ");
            System.out.println("          [3] - Editar Valor                      ");
            System.out.println("          [4] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Informe o novo nome: " ); produto.setNome(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 2:
                    System.out.print("Informe a novo tipo: " ); produto.setTipo(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 3:
                    System.out.print("Informe o novo valor: "); produto.setValor(scan.nextLong());
                    System.out.println("--------------------------------------------------");
                    break;
            }

        } while (opcao != 4);
    }

    public void deletar(List<Produto> produtos){
        Scanner scan = new Scanner(System.in);

        this.listar(produtos);
        System.out.print("Escolha qual remover: "); int opcao = scan.nextInt();

        System.out.println("--------------------------------------------------");
        System.out.println("-             REMOVIDO COM SUCESSO               -");
        System.out.println("--------------------------------------------------");

        produtos.remove(opcao);
    }

    public void listar(List<Produto> produtos) {

        System.out.println("--------------------------------------------------");
        System.out.println("-                LISTA DE PRODUTOS               -");
        System.out.println("--------------------------------------------------");

        int escolha = 0;
        Scanner scan = new Scanner(System.in);

        if (produtos.isEmpty()) {
            System.out.println("-            NENHUM PRODUTO CADASTRADO           -");
            System.out.println("--------------------------------------------------");
            System.out.println("-       DESEJA CADASTRAR UM NOVO PRODUTO         -");
            System.out.println("-                                                -");
            System.out.println("-          [1]- Sim      [2] - Não               -");
            System.out.println("--------------------------------------------------");
            escolha = scan.nextInt();

            if(escolha == 1){
                this.cadastrar(produtos);
                this.listar(produtos);
            }

        } else {

            for (int aux = 0; aux < produtos.size(); aux++) {
                System.out.println(" ID: " + aux);
                System.out.println(" Nome: " + produtos.get(aux).getNome());
                System.out.println(" Tipo: " + produtos.get(aux).getTipo());
                System.out.println(" Valor: " + produtos.get(aux).getValor());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}

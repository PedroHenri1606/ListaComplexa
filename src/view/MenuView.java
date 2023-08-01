package view;

import model.Endereco;
import model.Pedido;
import model.Pessoa;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {

    PessoaView pessoaView = new PessoaView();
    EnderecoView enderecoView = new EnderecoView();
    ProdutoView produtoView = new ProdutoView();
    PedidoView pedidoView = new PedidoView();

    List<Pessoa> pessoas = new ArrayList<>();
    List<Endereco> enderecos = new ArrayList<>();
    List<Produto> produtos = new ArrayList<>();
    List<Pedido> pedidos = new ArrayList<>();

    public void menu() {

        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Menu Pessoa                       ");
            System.out.println("          [2] - Menu Endereço                     ");
            System.out.println("          [3] - Menu Produto                      ");
            System.out.println("          [4] - Menu Pedidos                      ");
            System.out.println("          [5] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    pessoaView.menuPessoa(pessoas,enderecos);
                    break;
                case 2:
                    enderecoView.menuEndereco(enderecos);
                    break;
                case 3:
                    produtoView.menuProduto(produtos);
                    break;
                case 4:
                    pedidoView.menuPedido(pedidos,produtos,pessoas);
                    break;
            }

        } while(opcao != 5);

        scan.close();
    }
}

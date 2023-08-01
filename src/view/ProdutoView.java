package view;

import dao.ProdutoDAO;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class ProdutoView {


    public void menuProduto(List<Produto> produtos){

        int opcao = 0;
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Cadastrar Produto                 ");
            System.out.println("          [2] - Editar Produto                    ");
            System.out.println("          [3] - Remover Produto                   ");
            System.out.println("          [4] - Listar Produtos                   ");
            System.out.println("          [5] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    produtoDAO.cadastrar(produtos);
                    break;
                case 2:
                    produtoDAO.editar(produtos);
                    break;
                case 3:
                    produtoDAO.deletar(produtos);
                    break;
                case 4:
                    produtoDAO.listar(produtos);
                    break;
            }

        } while (opcao != 5);
    }
}

package view;

import dao.PedidoDAO;
import model.Pedido;
import model.Pessoa;
import model.Produto;

import java.util.List;
import java.util.Scanner;

public class PedidoView {

    public void menuPedido(List<Pedido> pedidos, List<Produto> produtos,List<Pessoa> pessoas){

        int opcao = 0;
        Scanner scan = new Scanner(System.in);
        PedidoDAO pedidoDAO = new PedidoDAO();

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Criar Pedido                      ");
            System.out.println("          [2] - Pedidos encerrados                ");
            System.out.println("          [3] - Pedidos em atendimento            ");
            System.out.println("          [4] - Listar Pedidos                    ");
            System.out.println("          [5] - Finalizar Pedido                  ");
            System.out.println("          [6] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    pedidoDAO.cadastrar(pedidos,produtos,pessoas);
                    break;
                case 2:
                    pedidoDAO.listarPorEncerrados(pedidos);
                    break;
                case 3:
                    pedidoDAO.listarPorAtendimento(pedidos);
                    break;
                case 4:
                    pedidoDAO.listar(pedidos);
                    break;
                case 5:
                    pedidoDAO.finalizarPedido(pedidos);
                    break;
            }


        } while (opcao != 6);


    }
}

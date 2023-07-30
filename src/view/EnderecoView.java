package view;

import dao.EnderecoDAO;
import model.Endereco;

import java.util.List;
import java.util.Scanner;

public class EnderecoView {

    public void menuEndereco(List<Endereco> enderecos){

        int opcao = 0;
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Scanner scan = new Scanner(System.in);

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Cadastrar Endereço                ");
            System.out.println("          [2] - Editar Endereço                   ");
            System.out.println("          [3] - Remover Endereço                  ");
            System.out.println("          [4] - Listar Endereços                  ");
            System.out.println("          [5] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    enderecoDAO.cadastrar(enderecos);
                    break;
                case 2:
                    enderecoDAO.editar(enderecos);
                    break;
                case 3:
                    enderecoDAO.deletar(enderecos);
                    break;
                case 4:
                    enderecoDAO.listar(enderecos);
                    break;
            }

        } while (opcao != 5);

    }
}

package view;

import dao.PessoaDAO;
import model.Endereco;
import model.Pessoa;

import java.util.List;
import java.util.Scanner;

public class PessoaView {

    public void menuPessoa(List<Pessoa> pessoas, List<Endereco> enderecos){

        int opcao = 0;
        Scanner scan = new Scanner(System.in);
        PessoaDAO pessoaDAO = new PessoaDAO();

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Cadastrar Pessoa                  ");
            System.out.println("          [2] - Editar Pessoa                     ");
            System.out.println("          [3] - Remover Pessoa                    ");
            System.out.println("          [4] - Listar Pessoa                     ");
            System.out.println("          [5] - Buscar Pessoa                     ");
            System.out.println("          [6] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

            switch (opcao){
                case 1:
                    pessoaDAO.cadastrar(pessoas,enderecos);
                    break;
                case 2:
                    pessoaDAO.editar(pessoas);
                    break;
                case 3:
                    pessoaDAO.deletar(pessoas);
                    break;
                case 4:
                    pessoaDAO.listar(pessoas);
                    break;
                case 5:
                    pessoaDAO.buscarPorNome(pessoas);
            }

        } while (opcao != 6);
    }
}

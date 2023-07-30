package view;

import model.Endereco;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {

    PessoaView pessoaView = new PessoaView();
    EnderecoView enderecoView = new EnderecoView();

    List<Pessoa> pessoas = new ArrayList<>();
    List<Endereco> enderecos = new ArrayList<>();

    public void menu() {

        int opcao = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Menu Pessoa                       ");
            System.out.println("          [2] - Menu Endereço                     ");
            System.out.println("          [3] - Sair                              ");
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
            }

        } while(opcao != 3);

        scan.close();
    }
}

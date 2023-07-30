package dao;

import model.Endereco;
import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaDAO {

    EnderecoDAO enderecoDAO = new EnderecoDAO();

    public List<Pessoa> cadastrar(List<Pessoa> pessoas, List<Endereco> enderecos) {

        Scanner scan = new Scanner(System.in);
        List<Endereco> enderecosPessoa = new ArrayList<>();
        int opcao;

        System.out.println("--------------------------------------------------");
        System.out.print("Informe o nome: ");
        String nome = scan.nextLine();
        System.out.print("Informe a idade: ");
        Integer idade = scan.nextInt();

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("-              Adicionar Endereço                -");
            enderecoDAO.listar(enderecos);

            System.out.print("Escolha um ID: ");
            int escolha = scan.nextInt();

            enderecosPessoa.add(enderecos.get(escolha));

            System.out.println("--------------------------------------------------");
            System.out.println("-        Deseja adicionar mais um endereço?      -");
            System.out.println("-                                                -");
            System.out.println("-            [1] - Sim       [2] - Não           -");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

        } while (opcao == 1);

        pessoas.add(new Pessoa(nome, idade, enderecosPessoa));
        return pessoas;
    }

    public void editar(List<Pessoa> pessoas) {

        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        this.listar(pessoas);
        System.out.print("Escolha o ID: ");
        int escolha = scan.nextInt();

        Pessoa pessoa = pessoas.get(escolha);

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Editar Nome                       ");
            System.out.println("          [2] - Editar idade                      ");
            System.out.println("          [3 ] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o novo nome: ");
                    pessoa.setNome(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 2:
                    System.out.print("Informe a nova idade: ");
                    pessoa.setIdade(scan.nextInt());
                    System.out.println("--------------------------------------------------");
                    break;
            }

        } while (opcao != 3);
    }

    public void deletar(List<Pessoa> pessoas) {
        Scanner scan = new Scanner(System.in);

        this.listar(pessoas);
        System.out.print("Escolha qual remover: ");
        int opcao = scan.nextInt();

        System.out.println("--------------------------------------------------");
        System.out.println("-             REMOVIDO COM SUCESSO               -");
        System.out.println("--------------------------------------------------");

        pessoas.remove(opcao);
    }

    public void listar(List<Pessoa> pessoas) {


        System.out.println("--------------------------------------------------");
        System.out.println("-                LISTA DE PESSOAS                -");
        System.out.println("--------------------------------------------------");

        if (pessoas.isEmpty()) {
            System.out.println("-           NENHUMA PESSOA CADASTRADO        -");
        } else {

            for (int aux = 0; aux < pessoas.size(); aux++) {
                int count = 0;

                System.out.println(" ID: " + aux);
                System.out.println(" Nome: " + pessoas.get(aux).getNome());
                System.out.println(" Idade: " + pessoas.get(aux).getIdade());
                System.out.println("--------------------------------------------------");
                System.out.println("-            Endereços dessa Pessoa              -");
                System.out.println("--------------------------------------------------");
                for (Endereco aux2 : pessoas.get(aux).getEnderecos()) {
                    System.out.println(" ID: " + count);
                    System.out.println(" CEP: " + aux2.getCep());
                    System.out.println(" Cidade: " + aux2.getCidade());
                    System.out.println(" Bairro: " + aux2.getBairro());
                    System.out.println(" Logadouro: " + aux2.getLogadouro());
                    System.out.println(" Numero: " + aux2.getNumero());
                    System.out.println("--------------------------------------------------");
                    count++;
                }
            }
        }
    }

    public void buscarPorNome(List<Pessoa> pessoas) {

        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.print  (" Informe o nome: ");
        String nome = scan.next();
        System.out.println("--------------------------------------------------");

        for(int aux = 0; aux < pessoas.size(); aux++){
                Pessoa pessoa = pessoas.get(aux);

                if (pessoa.getNome().equals(nome)) {

                System.out.println(" Nome: " + pessoa.getNome());
                System.out.println(" Idade: " + pessoa.getIdade());
                System.out.println("--------------------------------------------------");
                System.out.println("-            Endereços dessa Pessoa              -");
                System.out.println("--------------------------------------------------");

                for (Endereco aux2 : pessoas.get(aux).getEnderecos()) {
                    System.out.println(" CEP: " + aux2.getCep());
                    System.out.println(" Cidade: " + aux2.getCidade());
                    System.out.println(" Bairro: " + aux2.getBairro());
                    System.out.println(" Logadouro: " + aux2.getLogadouro());
                    System.out.println(" Numero: " + aux2.getNumero());
                    System.out.println("--------------------------------------------------");
                }
            }
        }
    }
}

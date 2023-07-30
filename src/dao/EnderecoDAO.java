package dao;

import model.Endereco;

import java.util.List;
import java.util.Scanner;

public class EnderecoDAO {

    public List<Endereco> cadastrar(List<Endereco> enderecos){

        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------------------");
        System.out.print  ("Informe o CEP: ");     String cep = scan.nextLine();
        System.out.print  ("Informe a cidade: ");  String cidade = scan.nextLine();
        System.out.print  ("Informe o bairro: ");  String bairro = scan.nextLine();
        System.out.print  ("Informe o logadouro: "); String logadouro = scan.nextLine();
        System.out.print  ("Informe o numero: ");    String numero = scan.nextLine();
        System.out.println("--------------------------------------------------");

        enderecos.add(new Endereco(cep,cidade,bairro,logadouro,numero));
        return enderecos;
    }

    public void editar(List<Endereco> enderecos){

        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        this.listar(enderecos);
        System.out.print("Escolha o ID: "); int escolha = scan.nextInt();

        Endereco endereco = enderecos.get(escolha);

        do{
            System.out.println("--------------------------------------------------");
            System.out.println("                                                  ");
            System.out.println("          [1] - Editar CEP                        ");
            System.out.println("          [2] - Editar Cidade                     ");
            System.out.println("          [3] - Editar Bairro                     ");
            System.out.println("          [4] - Editar Logadouro                  ");
            System.out.println("          [5] - Editar Numero                     ");
            System.out.println("          [6] - Sair                              ");
            System.out.println("                                                  ");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Informe o novo CEP: " ); endereco.setCep(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 2:
                    System.out.print("Informe a nova Cidade: " ); endereco.setCidade(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 3:
                    System.out.print("Informe o novo Bairro: "); endereco.setBairro(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 4:
                    System.out.print("Informe o novo Logadouro: "); endereco.setLogadouro(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;

                case 5:
                    System.out.print("Informe o novo numero: "); endereco.setNumero(scan.nextLine());
                    System.out.println("--------------------------------------------------");
                    break;
            }

        } while (opcao != 6);
    }

    public void deletar(List<Endereco> enderecos){
        Scanner scan = new Scanner(System.in);

        this.listar(enderecos);
        System.out.print("Escolha qual remover: "); int opcao = scan.nextInt();

        System.out.println("--------------------------------------------------");
        System.out.println("-             REMOVIDO COM SUCESSO               -");
        System.out.println("--------------------------------------------------");

        enderecos.remove(opcao);
    }

    public void listar(List<Endereco> enderecos) {

        System.out.println("--------------------------------------------------");
        System.out.println("-                LISTA DE ENDEREÇOS              -");
        System.out.println("--------------------------------------------------");

        int escolha = 0;
        Scanner scan = new Scanner(System.in);

        if (enderecos.isEmpty()) {
            System.out.println("-           NENHUM ENDEREÇO CADASTRADO           -");
            System.out.println("--------------------------------------------------");
            System.out.println("-      DESEJA CADASTRAR UM NOVO ENDEREÇO         -");
            System.out.println("-                                                -");
            System.out.println("-       [1]- Sim      [2] - Não                  -");
            System.out.println("--------------------------------------------------");
            escolha = scan.nextInt();

            if(escolha == 1){
                this.cadastrar(enderecos);
                this.listar(enderecos);
            }

        } else {

            for (int aux = 0; aux < enderecos.size(); aux++) {
                System.out.println(" ID: " + aux);
                System.out.println(" CEP: " + enderecos.get(aux).getCep());
                System.out.println(" Cidade: " + enderecos.get(aux).getCidade());
                System.out.println(" Bairro: " + enderecos.get(aux).getBairro());
                System.out.println(" Logadouro: " + enderecos.get(aux).getLogadouro());
                System.out.println(" Numero: " + enderecos.get(aux).getNumero());
                System.out.println("--------------------------------------------------");
            }
        }
    }
}

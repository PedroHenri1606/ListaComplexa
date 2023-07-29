import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        enderecos.add(new Endereco("Belmiro",2));
        enderecos.add(new Endereco("Portal da Foz", 200));

        Scanner scan = new Scanner(System.in);

        for(int i= 0; i < 1; i++){
            System.out.print("Nome: "); String nome = scan.nextLine();
            System.out.print("Idade: "); Integer idade = scan.nextInt();

            scan.nextLine();

            System.out.println("--------------------------");

            for(int aux = 0; aux < enderecos.size(); aux++){
                System.out.println("Id: " + aux + " - Rua: " + enderecos.get(aux).getRua() + " / N: " + enderecos.get(aux).getNumero());

            }

            System.out.println("--------------------------");
            System.out.print("Escolha o endereço: ");
            Integer escolha = scan.nextInt();

            pessoas.add(new Pessoa(nome,idade,enderecos.get(escolha)));
        }


        for(int i = 0; i < pessoas.size(); i++){
            System.out.println(pessoas.get(i).getNome());
            System.out.println(pessoas.get(i).getIdade());
            System.out.println(pessoas.get(i).getEndereco().getRua() + " / N:" + pessoas.get(i).getEndereco().getNumero());
        }
    }
}
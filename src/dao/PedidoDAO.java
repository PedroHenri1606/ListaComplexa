package dao;

import model.Endereco;
import model.Pedido;
import model.Pessoa;
import model.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedidoDAO {

    public List<Pedido> cadastrar(List<Pedido> pedidos, List<Produto> produtos, List<Pessoa> pessoas) {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Scanner scan = new Scanner(System.in);
        List<Produto> produtoSelecionado = new ArrayList<>();

        int opcao = 0;

        do {

            produtoDAO.listar(produtos);

            System.out.print(" Selecione o produto pelo ID: ");
            int escolha = scan.nextInt();
            System.out.print(" Informe a quantidade: ");
            int quantidade = scan.nextInt();
            System.out.println("--------------------------------------------------");

            produtoSelecionado.add(produtos.get(escolha));
            Produto produto = produtos.get(escolha);
            produto.setQuantidade(quantidade);

            System.out.println("--------------------------------------------------");
            System.out.println("-         Deseja adicionar mais um produto?      -");
            System.out.println("-                                                -");
            System.out.println("-            [1] - Sim       [2] - Não           -");
            System.out.println("--------------------------------------------------");

            opcao = scan.nextInt();

        } while (opcao == 1);

        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.listar(pessoas);

        System.out.print("Selecione a pessoa pelo ID: ");
        int escolha = scan.nextInt();

        Long valorTotal = 0L;

        for (Produto aux : produtoSelecionado) {
            valorTotal += (aux.getValor() * aux.getQuantidade());
        }

        Pedido pedidoGerado = new Pedido(produtoSelecionado, pessoas.get(escolha), valorTotal, "Em atendimento");
        pedidos.add(pedidoGerado);

        try {
            BufferedWriter salvar = new BufferedWriter(new FileWriter("Pedido-" + (pedidos.size()-1)));

            salvar.write("--------------------------------------------------"); salvar.newLine();
            salvar.write("-            Informações do Pedido               -"); salvar.newLine();
            salvar.write("--------------------------------------------------"); salvar.newLine();
            salvar.write(" Numero do pedido: " + (pedidos.size() -1));          salvar.newLine();
            salvar.write(" Cliente: " + pedidoGerado.getCliente().getNome());   salvar.newLine();

            for(Endereco aux3 : pedidoGerado.getCliente().getEnderecos()){
                salvar.write(" Logadouro: " + aux3.getLogadouro());             salvar.newLine();
                salvar.write(" Bairro: " + aux3.getBairro());                   salvar.newLine();
                salvar.write(" Numero: " + aux3.getNumero());                   salvar.newLine();
            }

            salvar.write("--------------------------------------------------"); salvar.newLine();
            salvar.write("-                    PRODUTOS                    -"); salvar.newLine();
            salvar.write("--------------------------------------------------"); salvar.newLine();

            for (Produto aux2 : pedidoGerado.getProdutos()) {
                salvar.write(" Produto: " + aux2.getNome());                    salvar.newLine();
                salvar.write(" Tipo: " + aux2.getTipo());                       salvar.newLine();
                salvar.write(" Quantide: " + aux2.getQuantidade());             salvar.newLine();
                salvar.write(" Valor: " + aux2.getValor() + " reais");          salvar.newLine();
                salvar.write("--------------------------------------------------"); salvar.newLine();
            }

            salvar.write(" VALOR TOTAL: R$" + pedidoGerado.getValor());       salvar.newLine();
            salvar.write("--------------------------------------------------"); salvar.newLine();

            salvar.close();

        } catch (Exception e) {

            System.out.println(" ERRO AO CRIAR ARQUIVO DE PEDIDO!");
        }
        return pedidos;
    }

    public void listarPorEncerrados(List<Pedido> pedidos){

        System.out.println("--------------------------------------------------");
        System.out.println("-          LISTA DE PEDIDOS ENCERRADOS           -");
        System.out.println("--------------------------------------------------");

        if (pedidos.isEmpty()) {
            System.out.println("-            NENHUM PEDIDO CADASTRADO       -");
        } else {

            for (int aux = 0; aux < pedidos.size(); aux++) {

                if(pedidos.get(aux).getSituacao().equals("Encerrado")){

                    int count = 0;

                    System.out.println();
                    System.out.println("--------------------------------------------------");
                    System.out.println("-            Informações do Pedido               -");
                    System.out.println("--------------------------------------------------");
                    System.out.println(" Numero do pedido: " + aux);
                    System.out.println(" Cliente: " + pedidos.get(aux).getCliente().getNome());

                    for(Endereco aux3 : pedidos.get(aux).getCliente().getEnderecos()){
                        System.out.println(" Logadouro: " + aux3.getLogadouro());
                        System.out.println(" Bairro: " + aux3.getBairro());
                        System.out.println(" Numero: " + aux3.getNumero());
                    }

                    System.out.println("--------------------------------------------------");
                    System.out.println("-                    PRODUTOS                    -");
                    System.out.println("--------------------------------------------------");

                    for (Produto aux2 : pedidos.get(aux).getProdutos()) {
                        System.out.println(" Produto: " + aux2.getNome());
                        System.out.println(" Tipo: " + aux2.getTipo());
                        System.out.println(" Quantide: " + aux2.getQuantidade());
                        System.out.println(" Valor: " + aux2.getValor() + " reais");
                        System.out.println("--------------------------------------------------");
                        count++;
                    }

                    System.out.println(" VALOR TOTAL: R$" + pedidos.get(aux).getValor());
                    System.out.println("--------------------------------------------------");

                    System.out.println();
                }
            }
        }
    }

    public void listarPorAtendimento(List<Pedido> pedidos){

        System.out.println("--------------------------------------------------");
        System.out.println("-        LISTA DE PEDIDOS EM ATENDIMENTO         -");
        System.out.println("--------------------------------------------------");

        if (pedidos.isEmpty()) {
            System.out.println("-            NENHUM PEDIDO CADASTRADO       -");
        } else {

            for (int aux = 0; aux < pedidos.size(); aux++) {

                if(pedidos.get(aux).getSituacao().equals("Em atendimento")){

                    int count = 0;

                    System.out.println();
                    System.out.println("--------------------------------------------------");
                    System.out.println("-            Informações do Pedido               -");
                    System.out.println("--------------------------------------------------");
                    System.out.println(" Numero do pedido: " + aux);
                    System.out.println(" Cliente: " + pedidos.get(aux).getCliente().getNome());

                    for(Endereco aux3 : pedidos.get(aux).getCliente().getEnderecos()){
                        System.out.println(" Logadouro: " + aux3.getLogadouro());
                        System.out.println(" Bairro: " + aux3.getBairro());
                        System.out.println(" Numero: " + aux3.getNumero());
                    }

                    System.out.println("--------------------------------------------------");
                    System.out.println("-                    PRODUTOS                    -");
                    System.out.println("--------------------------------------------------");

                    for (Produto aux2 : pedidos.get(aux).getProdutos()) {
                        System.out.println(" Produto: " + aux2.getNome());
                        System.out.println(" Tipo: " + aux2.getTipo());
                        System.out.println(" Quantide: " + aux2.getQuantidade());
                        System.out.println(" Valor: " + aux2.getValor() + " reais");
                        System.out.println("--------------------------------------------------");
                        count++;
                    }

                    System.out.println(" VALOR TOTAL: R$" + pedidos.get(aux).getValor());
                    System.out.println("--------------------------------------------------");

                    System.out.println();
                }
            }
        }
    }

    public void listar(List<Pedido> pedidos) {


        System.out.println("--------------------------------------------------");
        System.out.println("-                LISTA DE PEDIDOS                -");
        System.out.println("--------------------------------------------------");

        if (pedidos.isEmpty()) {
            System.out.println("-            NENHUM PEDIDO CADASTRADO       -");
        } else {

            for (int aux = 0; aux < pedidos.size(); aux++) {
                int count = 0;

                System.out.println();
                System.out.println("--------------------------------------------------");
                System.out.println("-            Informações do Pedido               -");
                System.out.println("--------------------------------------------------");
                System.out.println(" Numero do pedido: " + aux);
                System.out.println(" Cliente: " + pedidos.get(aux).getCliente().getNome());

                for(Endereco aux3 : pedidos.get(aux).getCliente().getEnderecos()){
                    System.out.println(" Logadouro: " + aux3.getLogadouro());
                    System.out.println(" Bairro: " + aux3.getBairro());
                    System.out.println(" Numero: " + aux3.getNumero());
                }

                System.out.println("--------------------------------------------------");
                System.out.println("-                    PRODUTOS                    -");
                System.out.println("--------------------------------------------------");

                for (Produto aux2 : pedidos.get(aux).getProdutos()) {
                    System.out.println(" Produto: " + aux2.getNome());
                    System.out.println(" Tipo: " + aux2.getTipo());
                    System.out.println(" Quantide: " + aux2.getQuantidade());
                    System.out.println(" Valor: " + aux2.getValor() + " reais");
                    System.out.println("--------------------------------------------------");
                    count++;
                }

                System.out.println(" VALOR TOTAL: R$" + pedidos.get(aux).getValor());
                System.out.println("--------------------------------------------------");

                System.out.println();
            }
        }
    }

    public void finalizarPedido(List<Pedido> pedidos){

        Scanner scan = new Scanner(System.in);
        int escolha = 0;

        this.listarPorAtendimento(pedidos);
        System.out.println("--------------------------------------------------");
        System.out.print  (" Informe o ID do pedido a encerrar: "); escolha = scan.nextInt();
        System.out.println("--------------------------------------------------");

        Pedido pedidoEscolhido = pedidos.get(escolha);
        pedidoEscolhido.setSituacao("Encerrado");

        //LOGICA DE ARQUIVOS AQUI
    }
}

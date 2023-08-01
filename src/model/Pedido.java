package model;

import java.util.List;

public class Pedido {

    private List<Produto> produtos;
    private Pessoa cliente;
    private Long valor;
    private String situacao;

    public Pedido(List<Produto> produtos, Pessoa cliente, Long valor, String situacao) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.valor = valor;
        this.situacao = situacao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}

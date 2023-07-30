package model;

public class Endereco {

    private String cep;
    private String cidade;
    private String bairro;
    private String logadouro;
    private String numero;

    public Endereco(String cep, String cidade, String bairro, String logadouro, String numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logadouro = logadouro;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

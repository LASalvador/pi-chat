package br.com.fatec.springbootpi.model;

public class ArquivoForm {
    private String descricao, nome;

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
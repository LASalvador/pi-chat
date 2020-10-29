package br.com.fatec.springbootpi.model;

import java.util.Date;
import java.util.List;

public class ArquivoForm {
    private String descricao, nome;
    private Date dataFechamento, dataPrevista;
    private Boolean atividadeAberta;
    private List<Long> idUsuarios;

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public List<Long> getIdUsuarios() {
        return idUsuarios;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdUsuarios(List<Long> idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

	public Date getDataPrevista() {
		return dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

    public Boolean getAtividadeAberta() {
        return atividadeAberta;
    }

    public void setAtividadeAberta(Boolean atividadeAberta) {
        this.atividadeAberta = atividadeAberta;
    }
}
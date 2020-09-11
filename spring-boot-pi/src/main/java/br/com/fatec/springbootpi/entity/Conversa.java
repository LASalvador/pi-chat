package br.com.fatec.springbootpi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversa")
public class Conversa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_covnersa")
    private Long idConversa;

    @Column(name = "data_iniciada")
    private Date dataInicial;

    @Column(name = "data_ultima_conversa")
    private Date dataUltimaConversa;

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataUltimaConversa(Date dataUltimaConversa) {
        this.dataUltimaConversa = dataUltimaConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    
    public Date getDataUltimaConversa() {
        return dataUltimaConversa;
    }
    
    public Long getIdConversa() {
        return idConversa;
    }
    
}
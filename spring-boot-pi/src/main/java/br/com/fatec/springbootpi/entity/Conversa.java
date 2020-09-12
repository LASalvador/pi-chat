/* package br.com.fatec.springbootpi.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "conversas")
    private Set<Usuario> usuarios;


    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataUltimaConversa(Date dataUltimaConversa) {
        this.dataUltimaConversa = dataUltimaConversa;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
} */
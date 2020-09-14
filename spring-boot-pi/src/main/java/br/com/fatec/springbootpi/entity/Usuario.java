package br.com.fatec.springbootpi.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    @Column(name = "cpf_usuario")
    private String cpfUsuario;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_conversa",
    joinColumns = { @JoinColumn(name = "id_usuario") },
    inverseJoinColumns = { @JoinColumn(name = "id_conversa") })
    private Set<Conversa> conversas;

    @ManyToOne
    @JoinColumn(name="id_tipo_usuario")
    private TipoUsuario tiposUsuarios;

    @Column(name = "data_criado")
    private Date dataCriado;

    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public String getCpfUsuario() {
         return cpfUsuario;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public TipoUsuario getTiposUsuarios() {
        return tiposUsuarios;
    }

    /* public Set<Conversa> getConversas() {
        return conversas;
    } */

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setTiposUsuarios(TipoUsuario tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }

    /* public void setConversas(Set<Conversa> conversas) {
        this.conversas = conversas;
    } */
}
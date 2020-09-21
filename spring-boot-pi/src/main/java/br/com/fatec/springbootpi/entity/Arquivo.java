package br.com.fatec.springbootpi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "arquivos")
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo")
    private Long idArquivo;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuarios;

    public Long getIdArquivo() {
        return idArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setIdArquivo(Long idArquivo) {
        this.idArquivo = idArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }
}
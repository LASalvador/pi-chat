package br.com.fatec.springbootpi.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mensagem")
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensagem")
    private Long idMensagem;

    @Column(name = "conteudo_mensagem")
    private String conteudoMsg;
    
    @Column(name = "data_criado")
    private Date dataCriado;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuarios;

    @OneToMany
    @JoinColumn(name="id_conversa")
    private Conversa conversas;
}
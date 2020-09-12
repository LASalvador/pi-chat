package br.com.fatec.springbootpi.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuarios;

    @OneToOne
    @JoinColumn(name="id_conversa")
    private Conversa conversas;
}
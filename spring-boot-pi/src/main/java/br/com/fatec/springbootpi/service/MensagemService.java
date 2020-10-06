package br.com.fatec.springbootpi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.exception.RegisterNotFound;
import br.com.fatec.springbootpi.repository.ConversaRepository;
import br.com.fatec.springbootpi.repository.MensagemRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository msgRepo;

    @Autowired
    private ConversaRepository cnvRepo;

    @Autowired
    private UsuarioRepository userRepo;

    @Transactional
    public Mensagem criarMensagem(String conteudo, Long idUsuario, Long idConversa) {
        Date data = new Date();

        Mensagem mensagem = new Mensagem();

        Conversa conversa = cnvRepo.findByIdConversa(idConversa);

        Usuario usuario = userRepo.findByIdUsuario(idUsuario);

        if(conversa != null && usuario != null){
            mensagem.setConteudoMsg(conteudo);
            mensagem.setConversas(conversa);
            mensagem.setUsuarios(usuario);
            mensagem.setDataCriado(data);
            msgRepo.save(mensagem);
        }

        else
            throw new RegisterNotFound("Conversa e/ou usuário não encontrado.");
        
        return mensagem;
    }

     public Mensagem buscarPorId(Long id){
        return msgRepo.findByIdMensagem(id);
    }

    public Mensagem editarMensagem(Long id, Mensagem mensagemUp){
        Mensagem mensagem = msgRepo.findByIdMensagem(id);
        if (mensagem != null){
            mensagem.setConteudoMsg(mensagemUp.getConteudoMsg());
            msgRepo.save(mensagem);
        }

        else
            throw new RegisterNotFound("Mensagem não encontrada.");

        return mensagem;
        
    }

    public void apagarMensagem(Long id){
        msgRepo.deleteById(id);
    }

}
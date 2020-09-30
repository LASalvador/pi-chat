package br.com.fatec.springbootpi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.repository.ConversaRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class ConversaService {
    
    @Autowired
    private ConversaRepository conversaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Conversa> listConversaById(long id){
        List<Conversa> conversa = conversaRepository.buscarConversaPeloIdDoUsuario(id);
        return conversa;
    }

    
    public Conversa cadastrarConversa(ArrayList<Long> idUsuarios){
        Conversa conversa = new Conversa();
        
        conversa.setUsuarios(new HashSet<Usuario>());

        for (Long id : idUsuarios) {            
            Usuario usuario = usuarioRepository.findByIdUsuario(id);
            if (usuario != null){
                conversa.getUsuarios().add(usuario);
            }            
        }     

        return conversa;
    }
}
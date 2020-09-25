package br.com.fatec.springbootpi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.repository.ConversaRepository;

@Service
public class ConversaService {
    
    @Autowired
    private ConversaRepository conversaRepository;

    public List<Conversa> listConversaById(long id){
        List<Conversa> conversa = conversaRepository.buscarConversaPeloIdDoUsuario(id);
        return conversa;
    }
}
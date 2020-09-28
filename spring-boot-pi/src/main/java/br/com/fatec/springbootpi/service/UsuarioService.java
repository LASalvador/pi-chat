package br.com.fatec.springbootpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    public Usuario buscarPorId(Long id){
        return userRepo.findByIdUsuario(id);
    }
    
}
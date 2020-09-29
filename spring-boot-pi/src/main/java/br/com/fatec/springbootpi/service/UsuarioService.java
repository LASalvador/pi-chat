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

    public Usuario editarUsuario(Long id, Usuario userUpdate){
        Usuario usuario = userRepo.findByIdUsuario(id);
        if (usuario != null){
            usuario.setNomeUsuario(userUpdate.getNomeUsuario());
            usuario.setCpfUsuario(userUpdate.getCpfUsuario());

            userRepo.save(usuario);
        }

        return usuario;
        
    }

    public void apagarUsuario(Long id){
        userRepo.deleteById(id);
    }
    
}
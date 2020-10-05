package br.com.fatec.springbootpi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.repository.TipoUsuarioRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private TipoUsuarioRepository tipoUserRepo;

    @Transactional
    public Usuario criarUsuario(String nomeUsuario, String cpfUsuario, Long idTipoUsuario) {
        Date dataAtual = new Date();

        Usuario usuario = new Usuario();

        TipoUsuario tipoUser = tipoUserRepo.findByIdTipoUsuario(idTipoUsuario);
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setCpfUsuario(cpfUsuario);
        usuario.setTiposUsuarios(tipoUser);
        usuario.setDataCriado(dataAtual);

        userRepo.save(usuario);

        return usuario;
    }

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
package br.com.fatec.springbootpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioService {

    @Autowired
    TipoUsuarioRepository tipoUserRepo;

    @Transactional
    public TipoUsuario criarTipoUsuario(String nomeTipoUsuario) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setNome(nomeTipoUsuario);

        // Validação
        if (tipoUsuario != null){
            tipoUserRepo.save(tipoUsuario);
        }
    

        return tipoUsuario;
    }

}
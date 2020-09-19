package br.com.fatec.springbootpi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.repository.ConversaRepository;
import br.com.fatec.springbootpi.repository.UsuarioRepository;
import br.com.fatec.springbootpi.security.ServicoService;

@SpringBootTest
@Transactional
//@Rollback
class SpringBootPiApplicationTests {

    @Autowired
    private ServicoService segService;

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private ConversaRepository convRepo;

	/* @Test
	void contextLoads() {
    } */
    
    // @Test
    // void testaServicoCriaUsuario(){
    //     Date x = new Date();
    //     Usuario usuario = segService.criarUsuario("PORPETA", "162.222.010-13", "ROLE_ALUNO", x);
    //     assertNotNull(usuario.getIdUsuario());
    // }

   // @Test
   // void testaUsuarioNomeAndCpf(){
   //     Usuario user = userRepo.findByNomeUsuarioAndCpfUsuario("PORPETA", "162.222.010-13");
   //     assertNotNull(user);
   // }

    // @Test
    // void testeUsuarioConversa(){
    //    // Usuario usuario = convRepo.
    //     List<Usuario> usuarios = convRepo.buscarUsuariosDaConversa((long) 1);
    //     assertFalse(usuarios.isEmpty());
    // }

    @Test
    void criaTipoUsuario(){
        TipoUsuario userType = segService.criarTipoUsuario("ROLE_PORPETONCIO");
        assertNotNull(userType.getIdTipoUsuario());
    }
}

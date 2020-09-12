package br.com.fatec.springbootpi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatec.springbootpi.*;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.security.ServicoService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootPiApplicationTests {

    @Autowired
    private ServicoService segService;

	/* @Test
	void contextLoads() {
    } */
    
    @Test
    void testaServicoCriaUsuario(){
        Date x = new Date();
        Usuario usuario = segService.criarUsuario("ademir", "666.666.666-6", "ROLE_ALUNO", x);
        assertNotNull(usuario);
    }


}

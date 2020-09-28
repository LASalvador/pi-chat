package br.com.fatec.springbootpi.controller;

import java.util.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.security.ServicoService;
import br.com.fatec.springbootpi.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
@Api(value = "Usuário")
public class UsuarioController {

    @Autowired
    private ServicoService segService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
	@ApiOperation(value = "Inserir um novo usuário")
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        Date x = new Date();
    
        usuario = segService.criarUsuario(usuario.getNomeUsuario(), usuario.getCpfUsuario(), "ROLE_USER", x);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/usuario/" + usuario.getIdUsuario()).build().toUri());
        return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value="/{id}")
    @ApiOperation(value = "Buscar todos usuários")
    public Usuario buscarUsuarioPorID(@PathVariable("id") Long Id){
        return usuarioService.buscarPorId(Id);
        
    }
}
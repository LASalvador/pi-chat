package br.com.fatec.springbootpi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.security.ServicoService;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private ServicoService segService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        Date x = new Date();
    
        usuario = segService.criarUsuario(usuario.getNomeUsuario(), usuario.getCpfUsuario(), "ROLE_USER", x);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/usuario/" + usuario.getIdUsuario()).build().toUri());
        return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
    }
}
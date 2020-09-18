package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.TipoUsuario;
import br.com.fatec.springbootpi.security.ServicoService;

@RestController
@RequestMapping(value = "/tipoUsuario")
@CrossOrigin
public class TipoUsuarioController {

    @Autowired
    private ServicoService segService;

    @PostMapping
    public ResponseEntity<TipoUsuario> cadastrarTipoUsuario(@RequestBody TipoUsuario tipoUsuario, UriComponentsBuilder uriComponentsBuilder){
    
        tipoUsuario = segService.criarTipoUsuario(tipoUsuario.getNome());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/tipoUsuario/" + tipoUsuario.getIdTipoUsuario()).build().toUri());
        return new ResponseEntity<TipoUsuario>(tipoUsuario, responseHeaders, HttpStatus.CREATED);
    }
}
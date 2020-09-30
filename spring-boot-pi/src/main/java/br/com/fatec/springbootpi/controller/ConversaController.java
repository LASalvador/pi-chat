package br.com.fatec.springbootpi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.service.ConversaService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/conversa")
public class ConversaController {
    
    @Autowired
    private ConversaService conversaService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar conversa pelo id do usuario")
    public ResponseEntity<List<Conversa>> listById(@PathVariable final Long id) {
        List<Conversa> c = conversaService.listConversaById(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping
    @ApiOperation(value = "Inserir uma nova conversa")
    public ResponseEntity<Conversa> cadastrarNovoConversa(@RequestBody ArrayList<Long> idUsuarios,
            UriComponentsBuilder uriComponentsBuilder) {
        
        Conversa conversa = conversaService.cadastrarConversa(idUsuarios);        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/conversa/" + conversa.getIdConversa()).build().toUri());
        return new ResponseEntity<Conversa>(conversa, responseHeaders, HttpStatus.CREATED);
    }
}
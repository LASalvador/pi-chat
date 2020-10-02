package br.com.fatec.springbootpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.model.Form.CriarConversaForm;
import br.com.fatec.springbootpi.service.ConversaService;
import br.com.fatec.springbootpi.service.MensagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/conversa")
@CrossOrigin(origins = "*")
@Api(value = "Conversa")
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
    public ResponseEntity<Conversa> cadastrarNovaConversa(@RequestBody CriarConversaForm criarConversaForm,
            UriComponentsBuilder uriComponentsBuilder) {
        
    
        Conversa conversa = conversaService.cadastrarConversa(criarConversaForm);        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/conversa/" + conversa.getIdConversa()).build().toUri());
        return new ResponseEntity<Conversa>(conversa, responseHeaders, HttpStatus.CREATED);
    }
}
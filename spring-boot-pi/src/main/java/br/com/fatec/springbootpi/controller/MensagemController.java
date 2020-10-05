package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.service.MensagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/mensagem")
@CrossOrigin(origins = "*")
@Api(value = "Mensagem")

public class MensagemController {
    @Autowired
    private MensagemService msgService;

    @PostMapping
	@ApiOperation(value = "Inserir uma nova mensagem")
    public ResponseEntity<Mensagem> cadastrarNovoUsuario(@RequestBody Mensagem mensagem, UriComponentsBuilder uriComponentsBuilder){

        mensagem = msgService.criarMensagem(mensagem.getConteudoMsg(), (long) 1, (long) 1);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/mensagem/" + mensagem.getIdMensagem()).build().toUri());
        return new ResponseEntity<Mensagem>(mensagem, responseHeaders, HttpStatus.CREATED);
    }
}
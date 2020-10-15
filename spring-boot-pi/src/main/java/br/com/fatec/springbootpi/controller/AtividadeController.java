package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fatec.springbootpi.entity.Atividade;
import br.com.fatec.springbootpi.model.AtividadeForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import br.com.fatec.springbootpi.service.AtividadeService;

@RestController
@RequestMapping(value = "/atividade")
@CrossOrigin(origins = "*")
@Api(value = "Atividade")
public class AtividadeController {
    
    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    @ApiOperation(value = "Inserir uma nova atividade")
    public ResponseEntity<Atividade> cadastrarNovaAtividade(@RequestBody AtividadeForm novaAtividade,
            UriComponentsBuilder uriComponentsBuilder) {

        Atividade atividade = atividadeService.criarAtividade(novaAtividade);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/atividade/" + atividade.getIdAtividade()).build().toUri());
        return new ResponseEntity<Atividade>(atividade, responseHeaders, HttpStatus.CREATED);
    }
}
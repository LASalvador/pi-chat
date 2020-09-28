package br.com.fatec.springbootpi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatec.springbootpi.entity.Conversa;
import br.com.fatec.springbootpi.service.ConversaService;

@RestController
@RequestMapping(value = "/conversa")
public class ConversaController {
    
    @Autowired
    private ConversaService conversaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Conversa>> listById(@PathVariable final Long id) {
        List<Conversa> c = conversaService.listConversaById(id);
        return ResponseEntity.ok(c);
    }
}
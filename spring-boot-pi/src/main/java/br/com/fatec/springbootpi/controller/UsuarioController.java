package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.UsuarioForm;
import br.com.fatec.springbootpi.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.fasterxml.jackson.annotation.JsonView;
import br.com.fatec.springbootpi.controller.View.UsuarioResumo;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
@Api(value = "Usuário")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation(value = "Inserir um novo usuário")
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody UsuarioForm novoUsuario,
            UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = usuarioService.criarUsuario(novoUsuario.getNomeUsuario(), novoUsuario.getCpfUsuario(), novoUsuario.getIdTipoUsuario());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(uriComponentsBuilder.path("/usuario/" + usuario.getIdUsuario()).build().toUri());
        return new ResponseEntity<Usuario>(usuario, responseHeaders, HttpStatus.CREATED);
    }

    @JsonView(View.UsuarioResumo.class)
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar todos usuários")
    public Usuario buscarUsuarioPorID(@PathVariable("id") Long Id) {
        return usuarioService.buscarPorId(Id);

    }

    @JsonView(UsuarioResumo.class)
    @PutMapping(value="/{id}")
    @ApiOperation(value = "Alterar usuário")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
        return usuarioService.editarUsuario(id, usuario);
    }

    @ApiOperation(value = "Deletar usuário por id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.apagarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
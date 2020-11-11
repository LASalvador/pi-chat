package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fatec.springbootpi.model.MensagemForm;
import br.com.fatec.springbootpi.service.MensagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "WebSocket")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MensagemService msgService;

    @ApiOperation(value = "Rota para chat flutuante utilizando websocket")
    @MessageMapping("/chat")
    public void sendMessage(@RequestBody MensagemForm novaMensagem) {
        System.out.println("Mensagem enviada: " + novaMensagem.getConteudoMsg() + " para: " + novaMensagem.getIdUsuario());
        
        msgService.criarMensagem(novaMensagem.getConteudoMsg(),novaMensagem.getIdUsuario(), novaMensagem.getIdConversa());
        
        simpMessagingTemplate.convertAndSend("/topic/messages/" + novaMensagem.getIdConversa(), novaMensagem);
    }
}
package br.com.fatec.springbootpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import br.com.fatec.springbootpi.entity.Mensagem;
import br.com.fatec.springbootpi.entity.Usuario;
import br.com.fatec.springbootpi.model.MensagemForm;
import br.com.fatec.springbootpi.service.MensagemService;
import br.com.fatec.springbootpi.websocket.MensagemSocket;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "WebSocket")
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MensagemService msgService;

    @ApiOperation(value = "Rota para chat flutuante utilizando websocket")
    @MessageMapping("/hello")
	@SendTo("/topic/greetings")
    public MensagemSocket sendMessage(MensagemForm novaMensagem) {
        
        Mensagem mensagem = msgService.criarMensagem(novaMensagem.getConteudoMsg(),novaMensagem.getIdUsuario(), novaMensagem.getIdConversa());
        
        MensagemSocket mSocket = new MensagemSocket();
        mSocket.setConteudoMsg(mensagem.getConteudoMsg());
        mSocket.setIdMensagem(mensagem.getIdMensagem());
        mSocket.setDataCriado(mensagem.getDataCriado());
        mSocket.setNomeUsuario(mensagem.getUsuarios().getNomeUsuario());

        return mSocket;
        // simpMessagingTemplate.convertAndSend("/topic/messages/" + novaMensagem.getIdConversa(), novaMensagem);
    }
}
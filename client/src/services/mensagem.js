import http from './http'

function enviarMensagem (conteudoMsg, idUsuario, idConversa) {
  const dadosMensagens = {
    conteudoMsg,
    idUsuario,
    idConversa
  }
  return http.post('mensagem', dadosMensagens)
}

export default {
  enviarMensagem
}

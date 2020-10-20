import api from './http'

function enviarMensagem (conteudoMsg, idUsuario, idConversa) {
  const dadosMensagens = {
    conteudoMsg,
    idUsuario,
    idConversa
  }
  return api.post('mensagem', dadosMensagens)
}

export default {
  enviarMensagem
}

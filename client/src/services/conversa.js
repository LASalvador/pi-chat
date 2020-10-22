import http from './http'

function pegarConversasUsuario (idUsuario) {
  return http.get(`conversa/${idUsuario}`)
}

export default {
  pegarConversasUsuario
}

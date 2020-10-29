import http from './http'

function pegarArquivosPorUsuario (idUsuario) {
  return http.get(`arquivo/${idUsuario}`)
}

export default {
  pegarArquivosPorUsuario
}

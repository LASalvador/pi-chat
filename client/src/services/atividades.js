import http from './http'

function pegarAtividades (idUsuario) {
  return http.get(`atividade/${idUsuario}`)
}

function enviarAtividades (descricaoAtividade, tituloAtividade, corAtividade, idUsuarios) {
  return http.post('atividade', { descricaoAtividade, tituloAtividade, corAtividade, idUsuarios })
}

export default { pegarAtividades, enviarAtividades }

import http from './http'

function pegarAtividades (idUsuario) {
  return http.get(`atividade/${idUsuario}`)
}

function enviarAtividades (descricaoAtividade, tituloAtividade, corAtividade, idUsuarios, dataPrevista) {
  return http.post('atividade', {
    descricaoAtividade,
    tituloAtividade,
    corAtividade,
    idUsuarios,
    dataPrevista,
    atividadeAberta: true
  })
}

export default { pegarAtividades, enviarAtividades }

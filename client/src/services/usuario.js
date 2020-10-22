import http from './http'

function buscarUsuarioPorCPF (cpf) {
  return http.get(`/usuario/cpf/${cpf}`)
}

export default {
  buscarUsuarioPorCPF
}

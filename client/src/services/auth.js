import api from './http'

function autenticar (documento, senha) {
  return api.post('/login', {
    document: documento,
    password: senha
  })
}

export default {
  autenticar
}

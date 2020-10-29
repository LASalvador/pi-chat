import axios from 'axios'
import store from '../store/index'

const api = axios.create({
  baseURL: 'https://8080-b3d39f7d-32e4-45f3-8461-90f8c039758a.ws-us02.gitpod.io/spring-app/'
})

function _beforeRequest (request) {
  const token = store.getters.getToken
  if (token) {
    request.headers.Authorization = `Bearer ${token}`
  }
  store.commit('beforeRequest')
  return request
}

function _afterRequest (response) {
  store.commit('afterRequest', {
    mensagem: 'EBA!! Sucesso na requisição!!',
    cor: '#43A047'
  })
  return response
}

function _onError (error) {
  let mensagem
  if (error.message.includes('401')) {
    mensagem = 'OPS! Você não está autenticado'
  } else if (error.message.includes('403')) {
    mensagem = 'OPS! Você não tem permissão para esta ação!!'
  } else {
    mensagem = 'OPS! Erro ao realizar requisição'
  }

  store.commit('afterRequest', {
    mensagem: mensagem,
    cor: '#E53935'
  })
  return Promise.reject(error)
}

api.interceptors.request.use(_beforeRequest, _onError)
api.interceptors.response.use(_afterRequest, _onError)

export default api

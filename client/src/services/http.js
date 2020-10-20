import axios from 'axios'

const api = axios.create({
  baseURL: 'https://8080-cb60a4b0-8b4e-4afb-bd8e-69169ff161cd.ws-us02.gitpod.io/spring-app/'
})

export default api

import axios from 'axios'

const api = axios.create({
  baseURL: 'https://8080-fea942d2-c440-4a50-b54e-e8db52ba1caf.ws-us02.gitpod.io/spring-app/'
})

export default api

import axios from 'axios'

const api = axios.create({
  baseURL: 'https://8080-b3ca221c-696d-4ccc-a8ca-6331ec05cf77.ws-us02.gitpod.io/spring-app/'
})

export default api

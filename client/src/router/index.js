import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Chat from '../views/Chat/Chat.vue'
import Atividades from '../views/Atividades/Atividades.vue'
import Arquivos from '../views/Arquivos/Arquivos.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/Arquivos',
    name: 'Arquivos',
    component: Arquivos
  },
  {
    path: '/chat',
    name: 'chat',
    component: Chat
  },
  {
    path: '/atividades',
    name: 'atividades',
    component: Atividades
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

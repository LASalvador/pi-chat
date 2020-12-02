<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
          <h1 class="bluePi--text">Atividades</h1>
      </v-col>
    </v-row>
    <v-row align="start" justify="center">
      <v-col cols="4" md="4" sm="12" xs="12" class="elevation-1 pa-3 ma-2">
        <v-list
          two-line
          class="overflow-y-auto"
          :max-height="windowSize"
        >
          <v-subheader>
              Atividades Abertas
          </v-subheader>
          <draggable v-model="atividadesAbertas" :options="{group:'people'}" @add="abrirAtividade" style="min-height: 10px">
            <template v-for="(item, index) in atividadesAbertas">
              <v-list-item
                :key="index"
                @click="visualizarAtividade(item)"
              >
                <v-btn :color="item.style.bg" fab small depressed="" :dark="item.style.darken" class="text-white mr-2">
                </v-btn>
                <v-list-item-content>
                  <v-list-item-title v-html="item.title"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </template>
          </draggable>
        </v-list>
      </v-col>
      <v-col cols="4" md="4" sm="12" xs="12" class="elevation-1 pa-3 ma-2">
        <v-list
          two-line
          class="overflow-y-auto"
          :max-height="windowSize"
        >
          <v-subheader>
              Atividades Concluídas
          </v-subheader>
          <draggable v-model="atividadesFechadas" :options="{group:'people'}" @add="fecharAtividade" style="min-height: 10px">
            <template v-for="(item, index) in atividadesFechadas">
              <v-list-item
                :key="index"
                @click="visualizarAtividade(item)"
              >
                <v-btn :color="item.style.bg" fab small depressed="" :dark="item.style.darken" class="text-white mr-2">
                </v-btn>
                <v-list-item-content>
                  <v-list-item-title v-html="item.title"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </template>
          </draggable>
        </v-list>
      </v-col>
      <Button
        fab
        right
        bottom
        fixed
        @click="openNewNote()"
        v-if="getUsuario.tiposUsuarios.nome === 'ROLE_ADMIN'"
        >
        <v-icon v-if="buttonNewNote">mdi-close</v-icon>
        <v-icon v-else>mdi-plus</v-icon>
      </Button>
    </v-row>
    <v-dialog
        v-model="buttonNewNote"
        fullscreen
        hide-overlay
        transition="dialog-bottom-transition"
      >
        <v-card tile>
          <v-row>
            <v-toolbar
              dark
              color="bluePi">
              <v-btn
                icon
                dark
                @click="buttonNewNote = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Nova Nota</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="addNote">
                  Salvar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
          </v-row>
          <v-card-text>
            <v-row>
                <v-col cols="12">
                  <Input
                    label="Título"
                    v-model="note.title"
                  />
                </v-col>
                <v-col cols="12">
                  <TextArea
                    label="Descrição da tarefa"
                    rows="4"
                    v-model="note.text"
                  />
                </v-col>
                <v-col cols="12">
                  <span v-for="(color, index) in styles" :key="index" style="margin-left: 5px">
                    <v-btn @click="selectColor(index)" :color="color.bg" fab small depressed="" :dark="color.darken" class="text-white">
                      <v-icon v-if="color.selected" color="white">mdi-check-bold</v-icon>
                    </v-btn>
                  </span>
                </v-col>
                <v-col cols="12">
                  <v-menu
                    v-model="menu"
                    :close-on-content-click="false"
                    transition="scale-transition"
                    offset-y
                    max-width="290px"
                    min-width="290px"
                  >
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        v-model="dataFormatada"
                        label="Data Conclusão"
                        hint="DD/MM/AAAA"
                        persistent-hint
                        prepend-icon="mdi-calendar"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                      ></v-text-field>
                    </template>
                    <v-date-picker
                      v-model="dataConclusao"
                      no-title
                      @input="menu = false"
                    ></v-date-picker>
                  </v-menu>
                </v-col>
                <v-col>
                  <Button
                    @click="sharedButton = !sharedButton"
                  >
                    Compartilhar Atividade
                  </Button>
                </v-col>
              </v-row>
          </v-card-text>
        </v-card>
      </v-dialog>
      <v-dialog
        v-model="sharedButton"
      >
        <v-card>
          <v-toolbar
              dark
              color="bluePi">
              <v-btn
                icon
                dark
                @click="sharedButton = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Enviar para</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="sharedButton = false"
                >
                  Selecionar usuários
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
        <SharedCard @selectUser="pegarUsuarios($event)"/>
        </v-card>
      </v-dialog>
      <v-dialog
        hide-overlay
        transition="dialog-bottom-transition"
        v-model="verAtividade"
      >
        <NoteCard :note="atividadeVisualizada" @click="atualizarAtividade(atividadeVisualizada.id, false)"/>
      </v-dialog>
  </v-container>
</template>

<script>
import NoteCard from '../../components/NoteCard/NoteCard.vue'
import Button from '../../components/Button/Button.vue'
import Input from '../../components/Input/Input.vue'
import TextArea from '../../components/TextArea/TextArea.vue'
import SharedCard from '../../components/ShareCard/ShareCard.vue'
import draggable from 'vuedraggable'
import api from '../../services/api'
import { mapGetters } from 'vuex'

export default {
  name: 'Atividades',
  components: {
    NoteCard,
    Button,
    Input,
    TextArea,
    SharedCard,
    draggable
  },
  data: () => ({
    buttonNewNote: false,
    sharedButton: false,
    verAtividade: false,
    atividadeVisualizada: {},
    atividadesFechadas: [],
    atividadesAbertas: [],
    idUsuarios: [],
    note: {
      title: '',
      text: '',
      created: '',
      style: ''
    },
    styles: [
      {
        bg: '#385F73',
        darken: true,
        selected: false
      },
      {
        bg: 'red',
        darken: true,
        selected: false
      },
      {
        bg: 'light-blue',
        darken: true,
        selected: false
      },
      {
        bg: 'teal',
        darken: true,
        selected: false
      },
      {
        bg: 'amber',
        darken: true,
        selected: false
      },
      {
        bg: 'green',
        darken: true,
        selected: false
      }
    ],
    dataConclusao: '',
    menu: false
  }),
  computed: {
    ...mapGetters([
      'getUsuario'
    ]),
    dataFormatada () {
      return this.formatDate(this.dataConclusao)
    },
    windowSize: function () {
      return window.innerHeight * 0.8
    }
  },
  mounted () {
    this.pegarAtividades()
    this.pegarAtividadesFechadas()
  },
  methods: {
    fecharAtividade (event) {
      const idAtividade = this.atividadesFechadas[event.newIndex].id
      this.atualizarAtividade(idAtividade, false)
    },
    abrirAtividade (event) {
      const idAtividade = this.atividadesAbertas[event.newIndex].id
      this.atualizarAtividade(idAtividade, true)
    },
    formatDate (date) {
      if (!date) return null
      const [year, month, day] = date.split('-')
      return `${day}/${month}/${year}`
    },
    pegarUsuarios (listaIdUsuarios) {
      this.idUsuarios = listaIdUsuarios
    },
    addNote () {
      let newNote = {}
      newNote = Object.assign(newNote, this.note)
      if (newNote.title && newNote.text) {
        console.log(this.idUsuarios)
        api.atividades.enviarAtividades(newNote.text, newNote.title, newNote.style.bg, [this.getUsuario.idUsuario, ...this.idUsuarios], this.dataConclusao)
          .then(resposta => {
            this.buttonNewNote = false
            this.sharedButton = false
            this.clearNote()
            this.pegarAtividades()
          })
          .catch(erro => {
            console.log(erro)
          })
      }
    },
    selectColor (index) {
      this.styles.map(e => {
        e.selected = false
      })
      this.styles[index].selected = true
      this.note.style = this.styles[index]
    },
    clearNote () {
      for (const key in this.note) {
        this.note[key] = ''
      }
      this.styles.map(e => {
        e.selected = false
      })
    },
    openNewNote () {
      this.buttonNewNote = true
      this.selectColor(0)
    },
    pegarAtividades () {
      api.atividades.pegarAtividades(this.getUsuario.idUsuario)
        .then(resposta => {
          const atividades = resposta.data.map(atividade => {
            var usuarios = atividade.usuarios.reduce((total, usuario, index, arr) => {
              if (index === arr.length - 1) {
                return total + usuario.nomeUsuario
              } else {
                return total + usuario.nomeUsuario + ', '
              }
            }, '')
            return {
              title: atividade.tituloAtividade,
              id: atividade.idAtividade,
              text: atividade.descAtividade,
              style: {
                bg: atividade.corAtividade,
                darken: true,
                selected: false
              },
              date: this.formatDate(atividade.dataPrevista.substring(0, 10)),
              users: usuarios,
              created: this.formatDate(atividade.dataCriado.substring(0, 10))
            }
          })
          this.atividadesAbertas = atividades
        })
        .catch(erro => {
          console.log(erro)
        })
    },
    pegarAtividadesFechadas () {
      api.atividades.pegarAtividadesFechadas(this.getUsuario.idUsuario)
        .then(resposta => {
          const atividades = resposta.data.map(atividade => {
            var usuarios = atividade.usuarios.reduce((total, usuario, index, arr) => {
              if (index === arr.length - 1) {
                return total + usuario.nomeUsuario
              } else {
                return total + usuario.nomeUsuario + ', '
              }
            }, '')
            return {
              title: atividade.tituloAtividade,
              id: atividade.idAtividade,
              text: atividade.descAtividade,
              style: {
                bg: atividade.corAtividade,
                darken: true,
                selected: false
              },
              date: this.formatDate(atividade.dataPrevista.substring(0, 10)),
              users: usuarios,
              created: this.formatDate(atividade.dataCriado.substring(0, 10)),
              closed: this.formatDate(atividade.dataFechamento.substring(0, 10))
            }
          })
          this.atividadesFechadas = atividades
        })
        .catch(erro => {
          console.log(erro)
        })
    },
    atualizarAtividade (idAtividade, status) {
      api.atividades.atualizarAtividade(idAtividade, status)
        .then(resposta => {
          this.pegarAtividades()
          this.pegarAtividadesFechadas()
        })
        .catch(erro => {
          console.log(erro)
        })
    },
    visualizarAtividade (atividade) {
      this.verAtividade = true
      this.atividadeVisualizada = atividade
    }
  }
}
</script>

<style scoped>
</style>

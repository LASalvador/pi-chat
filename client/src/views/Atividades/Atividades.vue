<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <h1 class="bluePi--text">Atividades</h1>
        <v-row>
          <v-col
            v-for="(note, index) in notes"
            :key="index"
            cols="12"
            sm="12"
            md="3"
          >
            <NoteCard :note="note" />
          </v-col>
        </v-row>
      </v-col>
      <Button
        fab
        right
        bottom
        fixed
        @click="openNewNote()">
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
                >
                  Compartilhar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
        <SharedCard />
        </v-card>
      </v-dialog>
  </v-container>
</template>

<script>
import NoteCard from '../../components/NoteCard/NoteCard.vue'
import Button from '../../components/Button/Button.vue'
import Input from '../../components/Input/Input.vue'
import TextArea from '../../components/TextArea/TextArea.vue'
import SharedCard from '../../components/ShareCard/ShareCard.vue'

export default {
  name: 'Atividades',
  components: {
    NoteCard,
    Button,
    Input,
    TextArea,
    SharedCard
  },
  data: () => ({
    buttonNewNote: false,
    sharedButton: false,
    notes: [
      {
        title: 'Lista de compras',
        text: 'Mussum Ipsum, cacilds vidis litro abertis. Diuretics paradis num copo é motivis de denguis. Nec orci ornare consequat. Praesent lacinia ultrices consectetur. Sed non ipsum felis. Casamentiss faiz malandris se pirulitá. Cevadis im ampola pa arma uma pindureta. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Si num tem leite então bota uma pinga aí cumpadi! Interagi no mé, cursus quis, vehicula ac nisi. Não sou faixa preta cumpadi, sou preto inteiris, inteiris.',
        style: {
          bg: 'red',
          darken: true,
          selected: false
        }
      },
      {
        title: 'Notas da aula',
        text: 'Mussum Ipsum, cacilds vidis litro abertis. Quem manda na minha terra sou euzis! Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Posuere libero varius. Nullam a nisl ut ante blandit hendrerit. Aenean sit amet nisi. In elementis mé pra quem é amistosis quis leo.',
        style: {
          bg: '#385F73',
          darken: true,
          selected: false
        }
      }
    ],
    note: {
      title: null,
      text: null,
      created: null,
      style: null
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
    ]
  }),
  methods: {
    addNote () {
      let newNote = {}
      newNote = Object.assign(newNote, this.note)
      if (newNote.title && newNote.text) {
        newNote.created = new Date()
        this.notes.push(newNote)
        this.buttonNewNote = false
        this.clearNote()
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
        this.note[key] = null
      }
      this.styles.map(e => {
        e.selected = false
      })
    },
    openNewNote () {
      this.buttonNewNote = true
      this.selectColor(0)
    }
  }
}
</script>

<style scoped>
</style>

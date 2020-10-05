<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-card>
          <v-card-title>
            Arquivos
            <v-spacer></v-spacer>
            <v-text-field
              v-model="search"
              append-icon="mdi-magnify"
              label="Search"
              single-line
              hide-details
            ></v-text-field>
          </v-card-title>
          <v-data-table
            :headers="headers"
            :items="desserts"
            :search="search"
          ></v-data-table>
        </v-card>
      </v-col>
       <Button
        fab
        right
        bottom
        fixed
        @click="openNewFile()">
        <v-icon v-if="buttonNewFile">mdi-close</v-icon>
        <v-icon v-else>mdi-plus</v-icon>
      </Button>
    </v-row>
    <v-dialog
        v-model="buttonNewFile"
        width="70%"
        heigth="50%"
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
                @click="buttonNewFile = false">
                <v-icon>mdi-close</v-icon>
              </v-btn>
              <v-toolbar-title>Novo Arquivo</v-toolbar-title>
              <v-spacer></v-spacer>
              <v-toolbar-items>
                <v-btn
                  dark
                  text
                  @click="addFile">
                  Salvar
                </v-btn>
              </v-toolbar-items>
            </v-toolbar>
          </v-row>
          <v-card-text>
            <v-row>
                <v-col cols="12">
                  <Input label='Nome do Arquivo' v-model="file.nomeArquivo"/>
                </v-col>
                <v-col cols="12">
                  <v-file-input
                    v-model="files"
                    placeholder="Suba seu arquivo"
                    label="Arquivo"
                    prepend-icon="mdi-paperclip"
                  >
                    <template v-slot:selection="{ text }">
                      <v-chip
                        small
                        label
                        color="primary"
                      >
                        {{ text }}
                      </v-chip>
                    </template>
                  </v-file-input>
                </v-col>
              </v-row>
          </v-card-text>

        </v-card>
      </v-dialog>
  </v-container>
</template>

<script>
import Input from '../../components/Input/Input.vue'
import Button from '../../components/Button/Button.vue'

export default {
  components: {
    Input,
    Button
  },
  data () {
    return {
      search: '',
      buttonNewFile: false,
      headers: [
        {
          text: 'Nome do Arquivo',
          align: 'start',
          value: 'nomeArquivo'
        },
        {
          text: 'Data de Criação',
          value: 'dataCriacao',
          sortable: false
        }
      ],
      desserts: [
        {
          nomeArquivo: 'Lucas Salvador',
          dataCriacao: '30/09/2020'
        },
        {
          nomeArquivo: 'Mayara Brígida',
          dataCriacao: '30/09/2020'
        }
      ],
      file: {
        nomeArquivo: null,
        dataCriacao: null
      }
    }
  },
  methods: {
    addFile () {
      let newFile = {}
      newFile = Object.assign(newFile, this.file)
      if (newFile.nomeArquivo) {
        newFile.dataCriacao = new Date()
        this.desserts.push(newFile)
        this.buttonNewFile = false
        this.clearFile()
      }
    },
    clearFile () {
      for (const key in this.file) {
        this.file[key] = null
      }
    },
    openNewFile () {
      this.buttonNewFile = true
    }
  }
}
</script>

<style scoped>
</style>

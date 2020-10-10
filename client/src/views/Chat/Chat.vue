<template>
  <v-container fluid>
      <v-row
        no-gutters
      >
          <v-col
            cols="3"
          >
            <v-card flat>
              <v-card-title>
                Conversas
                <v-spacer></v-spacer>
                <Button
                  icon
                >
                  <v-icon>mdi-plus</v-icon>
                </Button>
              </v-card-title>
            </v-card>
            <v-list
            two-line
            class="overflow-y-auto"
            :max-height="windowSize"
            >
            <v-list-item
              v-for="(item,key) in items"
              :key="key"
              @click="idConversa = key"
            >
              <v-list-item-content>
                  <v-list-item-title>
                    <span class="heading-6">{{item.author}}</span>
                  </v-list-item-title>
                  <v-list-item-subtitle class="body-2">
                    <span class="indigo--text text--darken-2">{{item.role}}</span>
                  </v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-action class="body-2">
                  {{item.date}}
                </v-list-item-action>
            </v-list-item>
          </v-list>
          </v-col>
          <v-col
            cols="9"
          >
            <MessageHeader :title="items[idConversa].author"/>
            <v-container>
              <v-row
                no-gutters
                align="center"
                justify="center"
              >
                <v-col
                  cols="12"
                >
                  <v-card
                    class="overflow-y-auto"
                    :max-height="maxChatListSize"
                    :min-height="minChatListSize"
                    color="transparent"
                    flat
                  >
                    <MessageCard
                      v-for="item in messageList"
                      :author="item.author"
                      :date="item.date"
                      :content="item.content"
                      :key="item.content"
                    />
                  </v-card>
                </v-col>
                <v-col cols="10">
                  <TextArea
                    label="digite aqui sua mensagem"
                    v-model="message"
                  />
                </v-col>
                <v-col cols="2">
                  <Button @click="addmessage"> Enviar </Button>
                </v-col>
              </v-row>
            </v-container>
          </v-col>
      </v-row>
  </v-container>
</template>

<script>
import MessageCard from '../../components/MessageCard/MessageCard.vue'
import MessageHeader from '../../components/MessageHeader/MessageHeader.vue'
import TextArea from '../../components/TextArea/TextArea.vue'
import Button from '../../components/Button/Button.vue'
import ApiMensagem from '../../services/api'

export default {
  components: {
    MessageCard,
    MessageHeader,
    TextArea,
    Button
  },
  data: () => ({
    items: [
      { author: 'Jose', date: 'Jan 9, 2014', role: 'Diretor' },
      { author: 'Ricardo', date: 'Jan 17, 2014', role: 'Diretor' },
      { author: 'Maria', date: 'Jan 28, 2014', role: 'Diretor' },
      { author: 'Jose', date: 'Jan 9, 2014', role: 'Diretor' },
      { author: 'Ricardo', date: 'Jan 17, 2014', role: 'Diretor' },
      { author: 'Maria', date: 'Jan 28, 2014', role: 'Diretor' },
      { author: 'Jose', date: 'Jan 9, 2014', role: 'Diretor' },
      { author: 'Ricardo', date: 'Jan 17, 2014', role: 'Diretor' },
      { author: 'Maria', date: 'Jan 28, 2014', role: 'Diretor' },
      { author: 'Work', date: 'Jan 28, 2014', role: 'Diretor' },
      { author: 'Jose', date: 'Jan 9, 2014', role: 'Diretor' },
      { author: 'Ricardo', date: 'Jan 17, 2014', role: 'Diretor' },
      { author: 'Maria', date: 'Jan 28, 2014', role: 'Diretor' }
    ],
    message: '',
    messageList: [],
    idConversa: 0
  }),
  computed: {
    maxChatListSize: function () {
      return window.innerHeight * 0.7
    },
    minChatListSize: function () {
      return window.innerHeight * 0.7
    },
    windowSize: function () {
      return window.innerHeight * 0.8
    }
  },
  methods: {
    async addmessage () {
      const resposta = await ApiMensagem.mensagem.enviarMensagem(this.message, 1, 1)
      const mensagem = resposta.data
      this.messageList.push({ author: 'Mayara', content: mensagem.conteudoMsg, date: '23/09/2020' })
      this.message = ''
    }
  }
}
</script>

<style scoped>

</style>

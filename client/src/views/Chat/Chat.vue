<template>
  <v-container fluid>
      <v-row
        no-gutters
      >
          <v-col
            cols="4"
          >
            <ChatList
              :items="items"
            />
          </v-col>
          <v-col
            cols="8"
          >
            <MessageHeader title="Joao"/>
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
                    :max-height="messageListSize"
                  >
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
                    />
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
                    />
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
                    />
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
                    />
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
                    />
                  </v-card>
                </v-col>
                <v-col cols="10">
                  <v-textarea
                    no-resize
                    clearable
                    rows="1"
                    label="Digite uma mensagem"
                  />
                </v-col>
                <v-col cols="2">
                  <v-btn> Enviar</v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-col>
      </v-row>
  </v-container>
</template>

<script>
import ChatList from '@/components/ChatList/ChatList.vue'
import MessageCard from '@/components/MessageCard/MessageCard.vue'
import MessageHeader from '@/components/MessageHeader/MessageHeader.vue'
export default {
  components: {
    ChatList,
    MessageCard,
    MessageHeader
  },
  data: () => ({
    items: [
      { author: 'Jose', date: 'Jan 9, 2014' },
      { author: 'Ricardo', date: 'Jan 17, 2014' },
      { author: 'Maria', date: 'Jan 28, 2014' },
      { author: 'Jose', date: 'Jan 9, 2014' },
      { author: 'Ricardo', date: 'Jan 17, 2014' },
      { author: 'Maria', date: 'Jan 28, 2014' },
      { author: 'Jose', date: 'Jan 9, 2014' },
      { author: 'Ricardo', date: 'Jan 17, 2014' },
      { author: 'Maria', date: 'Jan 28, 2014' },
      { author: 'Work', date: 'Jan 28, 2014' },
      { author: 'Jose', date: 'Jan 9, 2014' },
      { author: 'Ricardo', date: 'Jan 17, 2014' },
      { author: 'Maria', date: 'Jan 28, 2014' }
    ]
  }),
  computed: {
    messageListSize: function () {
      return window.innerHeight * 0.75
    }
  }
}
</script>

<style scoped>

</style>

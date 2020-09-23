<template>
  <v-container fluid>
      <v-row
        no-gutters
      >
          <v-col
            cols="3"
          >
            <ChatList
              :items="items"
            />
          </v-col>
          <v-col
            cols="9"
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
                    :max-height="maxChatListSize"
                    :min-height="minChatListSize"
                    color="transparent"
                  >
                    <MessageCard
                      author="Joao"
                      date="12/09/2020"
                      content="ola estou com duvida pode me ajudar?"
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
                  <Button> Enviar </Button>
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
import TextArea from '@/components/TextArea/TextArea.vue'
import Button from '@/components/Button/Button.vue'

export default {
  components: {
    ChatList,
    MessageCard,
    MessageHeader,
    TextArea,
    Button
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
    ],
    message: ''
  }),
  computed: {
    maxChatListSize: function () {
      return window.innerHeight * 0.75
    },
    minChatListSize: function () {
      return window.innerHeight * 0.7
    }
  }
}
</script>

<style scoped>

</style>

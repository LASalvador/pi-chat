<template>
   <v-card
        :color="note.style.bg"
        :dark="note.style.darken"
        height="100%"
    >
        <v-card-title class="headline">{{note.title}}</v-card-title>

        <v-card-text>
          <p class="white--text"><span class="font-weight-bold">Data Conclusão: </span>{{note.date}}</p>
          <p class="white--text"><span class="font-weight-bold">Usuarios: </span>{{note.users}}</p>
          <p class="white--text">{{ noteText }} </p>
          <p class="white--text font-weight-bold">Linha do tempo</p>
          <v-timeline dense>
              <v-timeline-item color="white">
                <span
                  :class="`white--text font-weight-bold`"
                >
                  Em {{note.created}} a atividade foi criada
                </span>
              </v-timeline-item>
              <v-timeline-item v-if="note.closed" color="white">
                <span
                  :class="`white--text font-weight-bold`"
                >
                  Em {{note.closed}} a atividade foi conclúida
                </span>
              </v-timeline-item>
          </v-timeline>

        </v-card-text>
        <v-card-actions>
        <v-spacer/>
        <v-btn
          color="blue-grey lighten-5"
          class="black--text"
          @click="$emit('click')"
        >
          Concluir
        </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script>
export default {
  name: 'NoteCard',
  props: {
    note: {
      type: Object,
      required: true
    }
  },
  computed: {
    noteText: function () {
      return this.note.text.replace(/(\\r)*\\n/g, '<br>')
    }
  }
}
</script>

<style scoped>

</style>

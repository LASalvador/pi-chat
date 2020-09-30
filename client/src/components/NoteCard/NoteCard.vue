<template>
   <v-card
        :color="note.style.bg"
        :dark="note.style.darken"
        height="100%"
    >
        <v-card-title class="headline">{{note.title}}</v-card-title>

        <v-card-text v-html="note.text.replace('\n','</br>')">
        </v-card-text>
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
  }
}
</script>

<style scoped>

</style>

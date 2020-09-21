<template>
  <v-card
    color="#e4e4e4"
  >
      <v-card-title>
          {{author}}
      </v-card-title>
      <v-card-subtitle>
          {{date}}
      </v-card-subtitle>
      <v-card-text>
          {{content}}
      </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: 'MessageCard',
  props: {
    author: {
      type: String,
      required: true
    },
    date: {
      type: String,
      required: true
    },
    content: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>

</style>

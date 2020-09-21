<template>
  <v-list
    two-line
    class="overflow-y-auto"
    :max-height="windowSize"
  >
    <v-list-item
      v-for="item in items"
      :key="item.title"
    >
      <v-list-item-content>
          <v-list-item-title v-text="item.author"></v-list-item-title>
          <v-list-item-subtitle v-text="item.date"></v-list-item-subtitle>
        </v-list-item-content>
    </v-list-item>
  </v-list>
</template>

<script>
export default {
  name: 'ChatList',
  computed: {
    windowSize: function () {
      return window.innerHeight
    }
  },
  props: {
    items: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>

</style>

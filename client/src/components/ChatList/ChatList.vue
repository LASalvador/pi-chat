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
</template>

<script>
export default {
  name: 'ChatList',
  computed: {
    windowSize: function () {
      return window.innerHeight * 0.8
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

<template>
  <v-app>
    <SideBar
      v-if="getToken"
    />
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>
<script>
import SideBar from './components/SideBar/SideBar.vue'
import { mapGetters } from 'vuex'

export default {
  components: {
    SideBar
  },
  computed: {
    ...mapGetters([
      'getToken'
    ])
  }
}
</script>
<style scoped>
</style>

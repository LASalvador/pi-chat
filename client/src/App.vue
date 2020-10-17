<template>
  <v-app>
    <SideBar />
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>
<script>
import SideBar from './components/SideBar/SideBar.vue'
export default {
  components: {
    SideBar
  }
}
</script>
<style scoped>
</style>

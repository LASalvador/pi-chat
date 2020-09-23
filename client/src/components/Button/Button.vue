<template>
    <v-btn
      dark
      color="purplePi"
    >
      <slot></slot>
    </v-btn>
</template>

<script>
export default {
  name: 'Button',
  props: {
    icon: {
      type: Boolean,
      default: false
    }
  }
}
</script>

<style>

</style>

<template>
    <v-btn
      dark
      color="#005796"
      @click="$emit('click')"
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

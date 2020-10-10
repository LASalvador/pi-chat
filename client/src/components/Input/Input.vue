<template>
  <v-text-field
    color="bluePi"
    :label="label"
    :value="value"
    :prepend-icon="prependIcon"
    @input="$emit('input', $event)"
    required
  />
</template>

<script>
export default {
  name: 'Input',
  props: {
    label: {
      type: String,
      required: true
    },
    value: {
      type: String,
      required: true
    },
    prependIcon: {
      type: String,
      default: ''
    }
  }
}
</script>

<style>

</style>

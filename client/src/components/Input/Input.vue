<template>
  <v-text-field
    color="bluePi"
    :label="label" 
    :value="value"
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
    }
  }
}
</script>

<style>

</style>
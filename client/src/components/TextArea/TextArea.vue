<template>
  <v-textarea
    no-resize
    clearable
    color="bluePi"
    rows="1"
    label="Digite uma mensagem"
    :value="value"
    @input="$emit('input', $event)"
  />
</template>

<script>
export default {
  name: 'TextArea',
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

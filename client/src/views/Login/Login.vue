<template>
  <v-container fluid>
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="8"
      >
        <div class="d-flex flex-column justify-space-between align-center">
          <v-img
            :aspect-ratio="16/9"
            src="../../assets/logo_teste.png"
            width="250"
          ></v-img>
        </div>
        <v-card color="transparent" flat>
          <p class="text-center bluePi--text headline font-weight-bold">Entrar</p>
          <v-row justify="center">
            <v-col cols="8">
              <Input label="CPF"/>
            </v-col>
            <v-col cols="8">
              <Input label="Senha"/>
            </v-col>
            <v-col cols="8">
              <div class="d-flex flex-column">
                <Button>
                  Entrar
                </Button>
              </div>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Input from '../../components/Input/Input.vue'
import Button from '../../components/Button/Button.vue'

export default {
  name: 'Login',
  data () {
    return {
    }
  },
  components: {
    Input,
    Button
  }
}
</script>

<style scoped>

</style>

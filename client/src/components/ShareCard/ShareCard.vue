<template>
  <v-card>
    <Input
      label="Pesquisar pelo nome"
      prepend-icon="mdi-magnify"
      v-model="search"
    />
    <v-container>
        <v-row>
            <v-col
              cols="3"
              v-for="(f, key) in user_filtros"
              :key="key"
            >
                <v-checkbox
                    v-model="filtros"
                    :label="f.label"
                    :value="f.value"
                ></v-checkbox>
            </v-col>
        </v-row>
    </v-container>
    <v-list dense>
      <v-subheader>Compartilhar com:</v-subheader>
       <v-list-item-group
          multiple
        >
        <v-list-item
          v-for="(user, key) in filteredList"
          :key="key"
        >
          <template v-slot:default="{ active }">
            <v-list-item-content>
              <v-list-item-title>
                {{user.name}}
                -
                <span class="bluePi--text"> {{user.role}} </span>
              </v-list-item-title>
            </v-list-item-content>
            <v-list-item-action>
              <v-checkbox
              :input-value="active"
              @click="user.selected = !user.selected">
              </v-checkbox>
            </v-list-item-action>
          </template>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>

<script>
import Input from '../Input/Input'

export default {
  name: 'Home',
  data: () => ({
    users: [
      {
        name: 'João',
        role: 'diretor'
      },
      {
        name: 'João',
        role: 'diretor'
      },
      {
        name: 'Atendente',
        role: 'atendente'
      },
      {
        name: 'Atendente',
        role: 'atendente'
      },
      {
        name: 'a',
        role: 'instrutor'
      },
      {
        name: 'b',
        role: 'cliente'
      },
      {
        name: 'c',
        role: 'cliente'
      }
    ],
    search: '',
    filtros: [],
    user_filtros: [
      {
        label: 'Diretor',
        value: 'diretor'
      },
      {
        label: 'Atendente',
        value: 'atendente'
      },
      {
        label: 'Instrutor',
        value: 'instrutor'
      },
      {
        label: 'Cliente',
        value: 'cliente'
      }
    ]
  }),
  computed: {
    filteredList: function () {
      if (this.search && this.filtros.length > 0) {
        return this.users.filter((user) => {
          const name = user.name.toLowerCase()
          const target = this.search.toLowerCase()
          return name.match(target) && this.filtros.includes(user.role)
        })
      }
      if (this.search) {
        return this.users.filter((user) => {
          const name = user.name.toLowerCase()
          const target = this.search.toLowerCase()
          return name.match(target)
        })
      }
      if (this.filtros.length > 0) {
        return this.users.filter((user) => {
          return this.filtros.includes(user.role)
        })
      }
      return this.users
    }
  },
  components: {
    Input
  }
}
</script>

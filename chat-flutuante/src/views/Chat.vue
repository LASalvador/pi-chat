<template>
  <v-app>
    <v-card>
    <v-toolbar dense color="#005796">
      <v-toolbar-title class="white--text">PorpsChat</v-toolbar-title>
    </v-toolbar>
    <v-card height="380" flat>
    </v-card>
      <div class="d-flex flex-column justify-center ml-1">
        <div class="d-flex flex-row">
          <v-text-field
            label="Mensagem"
            outlined
          ></v-text-field>
          <v-btn icon>
            <v-icon>mdi-send</v-icon>
          </v-btn>
        </div>
      </div>
    </v-card>
  </v-app>
</template>

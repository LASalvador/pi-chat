import React, { Component } from 'react';
import { SectionList, StyleSheet, Text, View } from 'react-native';


const Configuracoes = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>
        ⚙ CONFIGURAÇÃO 1
      </Text>
      <Text>
        ⚙ CONFIGURAÇÃO 2
      </Text>
      <Text>
        ⚙ CONFIGURAÇÃO 3
      </Text>
      <Text>
        ⚙ CONFIGURAÇÃO 4
      </Text>
      <Text>
        ⚙ CONFIGURAÇÃO 5
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
 container:{
   margin: 50,
   textAlign: 'center',
 },
});

export default Configuracoes;

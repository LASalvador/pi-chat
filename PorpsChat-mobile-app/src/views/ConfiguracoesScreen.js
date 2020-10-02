import React, { Component } from 'react';
import { SectionList, StyleSheet, Text, View } from 'react-native';


const Configuracoes = () => {
  return (
    <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
     <View style={styles.containerText}>
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
    </View>
  );
}

const styles = StyleSheet.create({
 containerText:{
   margin: 55,
 }
});

export default Configuracoes;

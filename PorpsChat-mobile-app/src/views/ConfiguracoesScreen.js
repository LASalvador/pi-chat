import React, { Component } from 'react';
import { SectionList, StyleSheet, Text, View } from 'react-native';


const Configuracoes = () => {
  return (
    <View style={styles.containerText}>
      <Text style={styles.texttop}>Chat Porps</Text>
      <Text style={styles.textconf}>Configurações</Text>
      <Text style={styles.text}
      onPress={() => Linking.openURL('#')}>
        ⚙ CONFIGURAÇÃO 1
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        ⚙ CONFIGURAÇÃO 2
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        ⚙ CONFIGURAÇÃO 3
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        ⚙ CONFIGURAÇÃO 4
      </Text>
       <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        ⚙ CONFIGURAÇÃO 5
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
 containerText:{
   justifyContent: 'left',
   margin: 20,
   textAlign: 'center',
 }, 
 text:{
   padding: 10,
 },
 texttop:{
   textAlign: 'left',
   fontWeight: 'bold',
   fontSize: 25,
 },
 textconf:{
   fontSize:19,
   textAlign: 'left',
   marginBottom:10,
 }
});

export default Configuracoes;

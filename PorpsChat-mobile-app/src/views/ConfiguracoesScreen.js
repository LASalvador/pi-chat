import React, { Component } from 'react';
import { SectionList, StyleSheet, Text, View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';


const Configuracoes = () => {
  return (
    <View style={styles.containerText}>
      <Text style={styles.texttop}>Chat Porps</Text>
      <Text style={styles.textconf}>Configurações</Text>
      <Text style={styles.text}
      onPress={() => Linking.openURL('#')}>
        <Icon name="gear" size={18} color="#999" /> CONFIGURAÇÃO 1
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        <Icon name="gear" size={18} color="#999" /> CONFIGURAÇÃO 2
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        <Icon name="gear" size={18} color="#999" /> CONFIGURAÇÃO 3
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        <Icon name="gear" size={18} color="#999" /> CONFIGURAÇÃO 4
      </Text>
       <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        <Icon name="gear" size={18} color="#999" /> CONFIGURAÇÃO 5
      </Text>

       <Text style={{ textAlign:'left', paddingTop:10,color: '#6E6E6E',fontWeight: 'bold'}} 
      onPress={() => Linking.openURL('#')}>
        <Icon name="sign-out" size={18} color="#999" /> SAIR
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
   textAlign: 'left',
   color: '#6E6E6E',
   fontWeight: 'bold',
 },
 texttop:{
   textAlign: 'left',
   fontWeight: 'bold',
   fontSize: 25,
   color: '#6E6E6E',
 },
 textconf:{
   fontSize:19,
   textAlign: 'left',
   marginBottom:10,
   fontStyle: 'italic',
   color: '#6E6E6E',
 }
});

export default Configuracoes;

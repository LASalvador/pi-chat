import React, { Component } from 'react';
import { SectionList, StyleSheet, Text, View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';


const Documentos = () => {
  return (
    <View style={styles.containerText}>
      <Text style={styles.texttop}>Chat Porps</Text>
      <Text style={styles.textconf}>Documentos</Text>
      <Text style={styles.text}
      onPress={() => Linking.openURL('#')}>
         Atendente 1 <Icon name="download" size={18} color="#999" />
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        Atendente 2 <Icon name="download" size={18} color="#999" />
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        Atendente 1 <Icon name="download" size={18} color="#999" />
      </Text>
      <Text style={styles.text} 
      onPress={() => Linking.openURL('#')}>
        Atendente 3 <Icon name="download" size={18} color="#999" />
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

export default Documentos;
 
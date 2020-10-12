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



export default Documentos;
 
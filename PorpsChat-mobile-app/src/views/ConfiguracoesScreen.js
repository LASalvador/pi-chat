import * as React from 'react';
import { View, Text } from 'react-native';


export default function ConfiguracoesScreen({ navigation }) {
    return (
      <View style={{ flex: 1, alignItems: 'center' }}>
      <View style={{width:"100%",  marginTop:40, marginStart:20}}>
          <Text style={{fontSize:30}}>Configurações</Text>
      </View>
    </View>
    );
  }
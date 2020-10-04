import * as React from "react";
import { View, Text, TouchableOpacity } from "react-native";

export default function ConversaScreen({ navigation }) {
  return (
    <View style={{ flex: 1, alignItems: "center" }}>
      <View style={{ width: "100%", marginTop: 40, marginStart: 20 }}>
        <Text style={{ fontSize: 30 }}>Conversas</Text>
      </View>
      <View style={{ width: "100%", borderWidth: 1, margin: 20, padding:20 }}>
        <TouchableOpacity onPress={() => {navigation.navigate("ConversaDetail", {name:"Instrutor 1"})}}>
          <Text>Instrutor 1</Text>
        </TouchableOpacity>
      </View>
      <View style={{ width: "100%", borderWidth: 1, margin: 20, padding:20 }}>
      <TouchableOpacity onPress={() => {navigation.navigate("ConversaDetail", {name:"Instrutor 2"})}}>
          <Text>Instrutor 2</Text>
        </TouchableOpacity>
      </View>
      <View style={{ width: "100%", borderWidth: 1, margin: 20, padding:20 }}>
      <TouchableOpacity onPress={() => {navigation.navigate("ConversaDetail", {name:"Instrutor 3"})}}>
          <Text>Instrutor 3</Text>
        </TouchableOpacity>
      </View>
      <View style={{ width: "100%", borderWidth: 1, margin: 20, padding:20 }}>
      <TouchableOpacity onPress={() => {navigation.navigate("ConversaDetail", {name:"Instrutor 4"})}}>
          <Text>Instrutor 4</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

import * as React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";

import LoginScreen from "./views/LoginScreen";
import HomeScreen from "./views/HomeScreen";
import FuncionariosScreen from "./views/FuncionariosScreen";

const Stack = createStackNavigator();

function App() {
  const isLoggedIn = true;
  const commonScreens = {
    Home: HomeScreen,
  };

  const authScreens = {
    Login: LoginScreen,
    // SignUp: SignUpScreen,
  };

  const userScreens = {
    // Home: HomeScreen,
    // Profile: ProfileScreen,
  };

  const funcionariosscreen{
   //FuncionariosScreen
  };

  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerShown: false,
        }}
      >
        {Object.entries({
          // Use the screens normally
          ...commonScreens,
          // Use some screens conditionally based on some condition
          ...(isLoggedIn ? userScreens : authScreens),
        }).map(([name, component]) => (
          <Stack.Screen name={name} component={component} />
        ))}
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;

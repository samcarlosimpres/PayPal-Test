/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */

var PayPalAndroid = require('react-native-paypal');
var Button = require('react-native-button');
import React, {
  AsyncStorage,
  AppRegistry,
  Component,
  StyleSheet,
  Text,
  View
} from 'react-native';

class newpay extends Component {

  paypal(){
    PayPalAndroid.paymentRequest({
      clientId: '............',
      environment: PayPalAndroid.SANDBOX,
      price: '0.01',
      currency: 'EUR',
      description: 'PayPal Test'
    }).then((confirm, payment) => console.log('Paid'))
    .catch((error_code) => console.error('Failed to pay through PayPal'));
  }

  render() {
    return (
      <View style={styles.container}>
        <Button
          style={{fontSize: 20, color: 'green'}}
          styleDisabled={{color: 'red'}}
          onPress={this.paypal}
        >
          PayPal Test
        </Button>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('newpay', () => newpay);

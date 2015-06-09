# CallJavaFunctionFromJavascriptPlugin
A simple Phone-Gap Android plugin that demonstrates how to call a Java function from JavaScript to do some native code.

The plugin gives you a ```CallJavaFunctionFromJavascriptPlugin``` object that provides simple native Android functions.

## Using
Clone the plugin

```
$ git clone https://github.com/EslamEl-Meniawy/CallJavaFunctionFromJavascriptPlugin.git
```
Create a new Cordova Project
```
$ cordova create app com.example.app app
```
Install the plugin
```
$ cd app
$ cordova plugin install ../CallJavaFunctionFromJavascriptPlugin
```
Edit ```www/js/index.js``` and add the following code inside ```onDeviceReady```

- [ ] Writing to Shared Preferences
```
var success = function() {
    alert("Saved successfully to preferences");
}

var failure = function() {
    alert("Error calling Plugin");
}

CallJavaFunctionFromJavascriptPlugin.saveToPreferences("Preferences Name", "Key", "Value", success, failure);
```
- [ ] Reading from Shared Preferences
```
var success = function() {
    alert("Success");
}

var failure = function() {
    alert("Error calling Plugin");
}

CallJavaFunctionFromJavascriptPlugin.readFromPreferences("Preferences Name", "Key", "Default Value", success, failure);
```
- [ ] Making Toast
```
var success = function(data) {
    alert(data);
}

var failure = function() {
    alert("Error calling Plugin");
}

CallJavaFunctionFromJavascriptPlugin.makeToast("Message", "Duration [short | long]", success, failure);
```
Install Android platform
```
cordova platform add android
```
Run the code
```
cordova run android
```
## Methods
* CallJavaFunctionFromJavascriptPlugin.saveToPreferences
* CallJavaFunctionFromJavascriptPlugin.readFromPreferences
* CallJavaFunctionFromJavascriptPlugin.makeToast

/* 
* @Author: Eslam El-Meniawy
* @Date: 2015-06-09 21:29:10
* @Last Modified by: eslam
* @Last Modified time: 2015-06-09 22:05:57
*
* Dear maintainer:
* When I wrote this, only God and I understood what I was doing
* Now, God only knows
* So, good luck maintaining the code :D
*/

module.exports = {
	saveToPreferences: function (prefName, key, value, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "CallJavaFunctionFromJavascriptPlugin", "saveToPreferences", [prefName, key, value]);
	},
	readFromPreferences: function (prefName, key, defaultValue, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "CallJavaFunctionFromJavascriptPlugin", "readFromPreferences", [prefName, key, defaultValue]);
	},
	makeToast: function (message, duration, successCallback, errorCallback) {
		cordova.exec(successCallback, errorCallback, "CallJavaFunctionFromJavascriptPlugin", "makeToast", [message, duration]);
	}
};
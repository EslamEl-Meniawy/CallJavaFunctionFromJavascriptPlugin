/* 
* @Author: Eslam El-Meniawy
* @Date: 2015-06-09 21:29:21
* @Last Modified by: eslam
* @Last Modified time: 2015-06-09 22:08:51
*
* Dear maintainer:
* When I wrote this, only God and I understood what I was doing
* Now, God only knows
* So, good luck maintaining the code :D
*/

package elmeniawy.eslam.plugin;

import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class NotificationsPlugin extends CordovaPlugin {

    public NotificationsPlugin() {
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("saveToPreferences")) {
        	String PREF_FILE_NAME = args.getString(0);
        	String preferenceName = args.getString(1);
        	String preferenceValue = args.getString(2);
        	cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences sharedPreferences = cordova.getActivity().getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
			        SharedPreferences.Editor editor = sharedPreferences.edit();
			        editor.putString(preferenceName, preferenceValue);
			        editor.apply();
                    callbackContext.success();
                }
            });
        	return true;
        } else if (action.equals("readFromPreferences")) {
        	String PREF_FILE_NAME = args.getString(0);
        	String preferenceName = args.getString(1);
        	String defaultValue = args.getString(2);
        	cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    SharedPreferences sharedPreferences = cordova.getActivity().getApplicationContext().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
			        String result = sharedPreferences.getString(preferencesName, defaultValue);
                    callbackContext.success(result);
                }
            });
        	return true;
        } else if (action.equals("makeToast")) {
        	String message = args.getString(0);
        	String duration = args.getString(1);
        	cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (duration.equals("short")) {
		        		Toast.makeText(cordova.getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
		        	} else {
		        		Toast.makeText(cordova.getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
		        	}
		        	callbackContext.success();
                }
            });
        	return true;
        }
        return false;
    }
}
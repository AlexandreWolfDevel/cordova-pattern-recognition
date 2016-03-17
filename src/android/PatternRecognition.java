package com.example.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class PatternRecognition extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("locate")) {

            // String location = data.getString(0);
            // Future information to locate 
            
            // startActivity
            
            callbackContext.success("Closed by User");

            return true;

        } else {
            return false;
        }
    }
}

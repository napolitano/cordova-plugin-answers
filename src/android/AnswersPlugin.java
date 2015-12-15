package com.napolitano.cordova.plugin.answers;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.ContentViewEvent;
import com.crashlytics.android.answers.CustomEvent;
import com.crashlytics.android.answers.LoginEvent;
import com.crashlytics.android.answers.SignUpEvent;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Iterator;

public class AnswersPlugin extends CordovaPlugin {
    private final String pluginName = "AnswersPlugin";

    @Override
    public boolean execute(final String action, final JSONArray data, final CallbackContext callbackContext) {
        Log.d(pluginName, pluginName + " called with options: " + data);

        Class params[] = new Class[2];
        params[0] = JSONArray.class;
        params[1] = CallbackContext.class;

        try{
            Method method = this.getClass().getDeclaredMethod(action, params);
            method.invoke(this, data, callbackContext);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return true;
    }

    public void sendSignUp(final JSONArray data, final CallbackContext context) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SignUpEvent evt = new SignUpEvent();
                Answers.getInstance()
                        .logSignUp(evt);
            }
        });
    }

    public void sendLogIn(final JSONArray data, final CallbackContext context) {
        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LoginEvent evt = new LoginEvent();
                Answers.getInstance()
                        .logLogin(evt);
            }
        });
    }

    public void sendContentView(final JSONArray data, final CallbackContext context) {
        final JSONObject obj = data.optJSONObject(0);

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ContentViewEvent evt = new ContentViewEvent();

                evt.putContentName(obj.optString("name"));
                evt.putContentType(obj.optString("type"));
                evt.putContentId(obj.optString("id"));

                if( obj.has("attributes") ) {
                    JSONObject json = obj.optJSONObject("attributes");

                    Iterator<String> keys = json.keys();
                    while(keys.hasNext()){
                        String key = keys.next();

                        try {
                            evt.putCustomAttribute(key, json.getString(key));
                        } catch(Exception e) {}
                    }
                }

                Answers.getInstance().logContentView(evt);
            }
        });
    }

    public void sendCustomEvent(final JSONArray data, final CallbackContext context) {
        final JSONObject obj = data.optJSONObject(0);

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                CustomEvent evt = new CustomEvent(obj.optString("name"));

                if( obj.has("attributes") ) {
                    JSONObject json = obj.optJSONObject("attributes");

                    Iterator<String> keys = json.keys();
                    while(keys.hasNext()){
                        String key = keys.next();

                        try {
                            evt.putCustomAttribute(key, json.getString(key));
                        } catch(Exception e) {}
                    }

                    Answers.getInstance().logCustom(evt);
                }
            }
        });
    }
}

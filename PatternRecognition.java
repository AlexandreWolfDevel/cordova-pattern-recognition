package br.univates.patternrecognition;

import org.json.JSONArray;  
import org.json.JSONException;  
import org.json.JSONObject;  
  
import android.content.Context;  
import android.content.res.Resources;  
import android.util.Log;  
  
import com.phonegap.api.Plugin;  
import com.phonegap.api.PluginResult;  
import com.phonegap.api.PluginResult.Status;  
  
public class PatternRecognition extends Plugin {  
      
  private static final String TAG = "PatternRecognition";  
  
  @Override  
  public PluginResult execute(String action, JSONArray dados, String arg2) {  
    Log.d(TAG, "Entrou no execute");  
  
    PluginResult result = null;  
    JSONObject resString = new JSONObject();  
    if (action.equalsIgnoreCase("getResourceString")) {  
      try {  
      
        Context ctx = PGAndroidStringSingleton.context;
        Resources res = ctx.getResources();  
        String packageName = ctx.getPackageName();
        JSONObject pesquisa = dados.getJSONObject(0);
        int resourceID = res.getIdentifier(pesquisa.getString("nome"), "string", packageName);
        String texto = res.getString(resourceID);  
        Log.d(TAG, "Retornando: " + texto);  
        resString.put("value", texto);  
        result = new PluginResult(Status.OK, resString);
        
    } catch (JSONException jsonEx) {  
        Log.d(TAG, "JSON Exception "+ jsonEx.getMessage());  
        result = new PluginResult(Status.JSON_EXCEPTION);  
    }  
    catch (Resources.NotFoundException rex) {  
        Log.e(TAG, "Não achou o recurso");  
        try {  
             resString.put("value",   
            "Não achou o recurso");  
        } catch (JSONException e) {  
                    e.printStackTrace();  
        }  
        result = new PluginResult(Status.JSON_EXCEPTION,   
        resString);  
    }  
    }  
    else {  
      result = new PluginResult(Status.INVALID_ACTION);  
      Log.d(TAG, "acao invalida : "+action);  
    }  
    return result;  
  }  
}

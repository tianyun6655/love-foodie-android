package dao;

import android.util.Log;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import untils.Contants;

/**
 * Created by tianyun chen on 2016/9/14.
 */
public class LoginDao extends BaseDao {
   private final String ACTION_NAME = Contants.loginApi;
    private final String TAG ="LoginDao";
    @Override
    public String getAcionName() {
        return ACTION_NAME;
    }

    @Override
    public String getTAG() {
        return TAG;
    }
  public void setParamer(String email,String password){
      Map<String,String> paramers = new HashMap<String,String>();
      paramers.put("email",email);
      paramers.put("password",password);
      loadData(paramers);
  }
    @Override
    protected void dealWithJson(JSONObject string) {
        Log.d(TAG,string.toString());
    }
}

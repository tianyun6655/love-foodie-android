package dao;

import android.util.Log;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import untils.Contants;

/**
 * Created by tianyun chen on 2016/9/14.
 */
public class SignUpDao extends BaseDao {
    private final String TAG="SignUpDao";
    private String actionName = Contants.saveUsetApi;
    @Override
    public String getAcionName() {
        return actionName;
    }

    public void setParamer(String name,String mobile,String password,String email){
        Map<String,String> paramers = new HashMap<String,String>();
        paramers.put("name",name);
        paramers.put("mobile",mobile);
        paramers.put("password",password);
        paramers.put("email",email);
        loadData(paramers);
    }
    @Override
    public String getTAG() {
        return TAG;
    }

    @Override
    protected void dealWithJson(JSONObject string) {
        Log.d(TAG,string.toString());
    }
}

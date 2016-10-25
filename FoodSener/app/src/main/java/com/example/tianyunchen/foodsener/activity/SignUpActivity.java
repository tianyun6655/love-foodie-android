package com.example.tianyunchen.foodsener.activity;

import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tianyunchen.foodsener.R;

import org.apache.http.impl.DefaultBHttpClientConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import dao.BaseDao;
import dao.SignUpDao;
import listener.DaoListener;
import untils.Contants;
import untils.HttpUtils;

/**
 * Created by tianyun chen on 2016/9/13.
 */
public class SignUpActivity extends BaseActivity implements DaoListener{
    private EditText edit_name;
    private EditText edit_mobile;
    private EditText edit_password;
    private EditText edit_email;
    private Button btn_signup;
    private final String TAG="SignUpAcitivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        initViews();
      }

    @Override
    public void initViews() {
           edit_email = (EditText)findViewById(R.id.input_email);
           edit_name = (EditText)findViewById(R.id.input_full_name);
           edit_mobile =(EditText)findViewById(R.id.input_mobile);
           edit_password = (EditText)findViewById(R.id.input_Password);
           btn_signup = (Button)findViewById(R.id.btn_sign_up);
           btn_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"lisenter");
         if(v.getId()==btn_signup.getId()){
             sendHttp();
         }
    }
    private void sendHttp(){
        SignUpDao signUpDao = new SignUpDao();
        signUpDao.setParamer(edit_name.getText().toString(),
                edit_mobile.getText().toString(),
                edit_password.getText().toString(),
                edit_email.getText().toString());
        signUpDao.setDaoListener(this);
    }


    @Override
    public void onDataLoaded(BaseDao dao) {
        Log.d(TAG,"load data sucessful");
    }

    @Override
    public void onDataFailed(BaseDao dao) {
        Log.d(TAG,"load data failed");
    }
}

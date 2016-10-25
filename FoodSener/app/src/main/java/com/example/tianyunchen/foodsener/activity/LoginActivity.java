package com.example.tianyunchen.foodsener.activity;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  android.support.v4.app.ActivityOptionsCompat;

import com.example.tianyunchen.foodsener.R;

import dao.BaseDao;
import dao.LoginDao;
import listener.DaoListener;

/**
 * Created by tianyun chen on 2016/9/12.
 */
public class LoginActivity extends BaseActivity implements DaoListener {
    private static  final  String TAG ="LoginActivity";
    private EditText input_email;
    private EditText input_password;
    private Button btn_submit;
    private Button btn_signUp;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_layout);
        initViews();
        setLinster();
    }

    @Override
    public void initViews() {
        input_email = (EditText)findViewById(R.id.input_email);
        input_password = (EditText)findViewById(R.id.input_password);
        btn_submit = (Button)findViewById(R.id.button_submit);
        btn_signUp =(Button)findViewById(R.id.button_sign_up);


    }

    public void setLinster(){
        btn_submit.setOnClickListener(this);
        btn_signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"onclick");
        if(v.getId()==btn_submit.getId()){
            logIn();
        }else if(v.getId()==btn_signUp.getId()){
            Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
            startActivity(intent);
        }
    }

    private void logIn(){
        LoginDao loginDao = new LoginDao();
        loginDao.setDaoListener(this);
        loginDao.setParamer(input_email.getText().toString(),input_password.getText().toString());
       if(progressDialog==null){
           progressDialog = new ProgressDialog(this);
           progressDialog.setMessage("正在登录...");
           progressDialog.setCancelable(false);
       }
        progressDialog.show();
    }
    @Override
    public void onDataLoaded(BaseDao dao) {
           progressDialog.dismiss();
    }

    @Override
    public void onDataFailed(BaseDao dao) {
     progressDialog.dismiss();
    }
}

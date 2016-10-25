package com.example.tianyunchen.foodsener.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.tianyunchen.foodsener.R;
import com.special.ResideMenu.ResideMenu;

/**
 * Created by tianyun chen on 2016/9/13.
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
     private TextView textView;

     public  abstract  void initViews();


     public void setTitleTest(String title){
          textView = (TextView)findViewById(R.id.toolbar_text);
          textView.setText(title);
          ResideMenu resideMenu = new ResideMenu(this);
     }

     public void setTitleSize(float size){
          textView = (TextView)findViewById(R.id.toolbar_text);
          textView.setTextSize(size);
     }

}

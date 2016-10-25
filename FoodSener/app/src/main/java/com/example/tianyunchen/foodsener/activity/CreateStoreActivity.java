package com.example.tianyunchen.foodsener.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.tianyunchen.foodsener.R;

/**
 * Created by tianyun chen on 2016/10/10.
 */
public class CreateStoreActivity extends BaseActivity {
    private Button btn_submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_store);
        setTitleTest("AppName");
        initViews();
    }

    @Override
    public void initViews() {
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
        overridePendingTransition(R.anim.slide_bottom, R.anim.slide_bottom_out);

    }


}

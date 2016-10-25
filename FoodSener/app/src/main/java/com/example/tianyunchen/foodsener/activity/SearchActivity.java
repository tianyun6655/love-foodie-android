package com.example.tianyunchen.foodsener.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tianyunchen.foodsener.R;

import java.util.ArrayList;
import java.util.List;

import adapter.AddressRecycleViewAdapter;
import untils.SearchUntils;

/**
 * Created by tianyun chen on 2016/10/3.
 */
public class SearchActivity extends BaseActivity implements TextWatcher {
    private  RecyclerView recyclerView;
    private EditText editText;
    private List<String> dataarrayList;
    private AddressRecycleViewAdapter addressRecycleViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initViews();
        setListener();
        setAdapter();
        setTitleTest("App Name");
    }

    @Override
    public void initViews() {
         recyclerView = (RecyclerView)findViewById(R.id.address_recycle);
         editText = (EditText)findViewById(R.id.address_input);


    }
    private void setListener(){
              editText.addTextChangedListener(this);
    }
    public void setAdapter(){
        dataarrayList = new ArrayList<String>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addressRecycleViewAdapter = new AddressRecycleViewAdapter(this,dataarrayList);
        recyclerView.setAdapter(addressRecycleViewAdapter);

    }
    @Override
    public void onClick(View v) {
          editText.addTextChangedListener(this);
    }

    @Override
    public void setTitleTest(String title) {
        super.setTitleTest(title);
    }

     private void changedate(){
         dataarrayList.add("hello");
     }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        ArrayList<String> resultString  = SearchUntils.search(s.toString());
        addressRecycleViewAdapter.setData(resultString);
        addressRecycleViewAdapter.notifyDataSetChanged();
        Log.d("Hello",s+"");

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}

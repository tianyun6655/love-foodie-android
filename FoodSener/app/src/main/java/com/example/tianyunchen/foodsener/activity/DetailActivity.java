package com.example.tianyunchen.foodsener.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.tianyunchen.foodsener.R;

import adapter.SubFoodAdapter;
import adapter.SubRecycleAdapter;

/**
 * Created by tianyun chen on 2016/9/30.
 */
public class DetailActivity extends BaseActivity implements SubRecycleAdapter.SubCallBack{
    private final  static  String TAG="DetailActivity";
    private RecyclerView subRecycleView;
    private RecyclerView foodRecycleView;
    private ImageButton imageButton;
    private CardView cardView;
    private RelativeLayout innerMapLayout;
    private RelativeLayout innerInfoLayout;
    private View move;
    private TranslateAnimation translateAnimation;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initViews();
        bindAdapter();
        setTitleTest("AppName");
    }

    @Override
    public void initViews() {
        subRecycleView = (RecyclerView)findViewById(R.id.sub_catagory_recycle);
       subRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
           @Override
           public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
               Log.d(TAG,"the move x:"+dx);
               move.setX(move.getX()-dx);
           }
       });
        foodRecycleView = (RecyclerView)findViewById(R.id.sub_food_recycle);
        imageButton = (ImageButton)findViewById(R.id.map_img);
        imageButton.setOnClickListener(this);
        cardView = (CardView)findViewById(R.id.card_layout);
        innerMapLayout = (RelativeLayout)findViewById(R.id.inner_map_layout);
        innerInfoLayout  = (RelativeLayout)findViewById(R.id.inner_layout);
        move = findViewById(R.id.move);


    }

    private void bindAdapter(){
        SubRecycleAdapter subRecycleAdapter = new SubRecycleAdapter(this);
        subRecycleAdapter.setSubCallBack(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        subRecycleView.setLayoutManager(linearLayoutManager);
        subRecycleView.addItemDecoration(new MyItemDecoration(10));
        subRecycleView.setAdapter(subRecycleAdapter);
        SubFoodAdapter subFoodAdapter = new SubFoodAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        foodRecycleView.setLayoutManager(gridLayoutManager);
        foodRecycleView.addItemDecoration(new MyFoodItemDecoration(10,20));
        foodRecycleView.setAdapter(subFoodAdapter);

    }

    @Override
    public void setTitleTest(String title) {
        super.setTitleTest(title);
    }

    @Override
    public void onClick(View v) {
        int id  = v.getId();
        if (id == imageButton.getId()){
           ObjectAnimator anim =   ObjectAnimator.ofFloat(cardView,"rotationX",0f,360f).setDuration(1000);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                        innerInfoLayout.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    Log.d(TAG,"animator finish");
                      innerMapLayout.setVisibility(View.VISIBLE);
                    innerInfoLayout.setVisibility(View.GONE);

                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            anim.start();

        }
    }

    @Override
    public void startAnimation(final float x) {
        Log.d(TAG,x+"");
        ObjectAnimator animator = ObjectAnimator.ofFloat(move,"translationX",move.getX(),x).setDuration(300);
        animator.start();

    }

    private   class MyItemDecoration extends RecyclerView.ItemDecoration{
        private int offset;
        public MyItemDecoration(int offset){
            this.offset = offset;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State  qstate) {

            outRect.right = offset;
        }
    }
    private   class MyFoodItemDecoration extends RecyclerView.ItemDecoration{
        private int offset;
        private int offset2;
        public MyFoodItemDecoration(int offset,int offset2){
            this.offset = offset;
            this.offset2 = offset2;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            outRect.bottom = offset2;
            outRect.right = offset;
        }
    }
}

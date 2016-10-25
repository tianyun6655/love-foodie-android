package com.example.tianyunchen.foodsener.activity;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tianyunchen.foodsener.R;
import com.special.ResideMenu.ResideMenu;

import java.util.ArrayList;
import java.util.List;

import fragment.ReceiverFragment;
import fragment.SenderFragment;
import fragment.StoreFragment;
import fragment.WarmingFragment;
import untils.AnimationUtils;

public class MainActivity extends BaseActivity implements DrawerLayout.DrawerListener {
    private List<Fragment> fragmentList;
    private ReceiverFragment receiverFragment;
    private SenderFragment senderFragment;
    private LinearLayout search_layout;
    private ImageButton menu_icon;
    private RelativeLayout menu_layout;
    private LinearLayout order_layou, sell_layout, user_layout;
    private ImageButton filter_img;
    private DrawerLayout drawerLayout;
    private final int STATUS_MENU_CLOSE = 0;
    private final int STATUS_MENU_OPEN = 1;
    private int status_menu = 0;
    private final int DRAWER_STATUS_MENU_CLOSE = 0;
    private final int DRAWER_STATUS_MENU_OPEN = 1;
    private int drawer_status_menu = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initFragment();

    }

    @Override
    public void initViews() {
        // viewPager = (ViewPager)findViewById(R.id.view_pager);
        search_layout = (LinearLayout) findViewById(R.id.search_layout);
        search_layout.setOnClickListener(this);
        menu_icon = (ImageButton) findViewById(R.id.menu_img);
        menu_layout = (RelativeLayout) findViewById(R.id.menu_layout);
        menu_icon.setOnClickListener(this);
        order_layou = (LinearLayout) findViewById(R.id.order_layout);
        order_layou.setOnClickListener(this);
        sell_layout = (LinearLayout) findViewById(R.id.sell_layout);
        sell_layout.setOnClickListener(this);
        user_layout = (LinearLayout) findViewById(R.id.user_layout);
        user_layout.setOnClickListener(this);
        filter_img = (ImageButton) findViewById(R.id.filerts_img);
        filter_img.setOnClickListener(this);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == search_layout.getId()) {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_bottom, R.anim.slide_bottom_out);
        } else if (id == menu_icon.getId()) {
            if (status_menu == STATUS_MENU_CLOSE) {
                AnimationUtils.open_Menu(menu_layout, order_layou, sell_layout, user_layout);
                AnimationUtils.ratationMenuIcon(menu_icon, 500);
                status_menu = STATUS_MENU_OPEN;
            } else {
                AnimationUtils.close_menu(menu_layout);
                AnimationUtils.ratationMenuIcon2(menu_icon, 500);
                status_menu = STATUS_MENU_CLOSE;
            }
        } else if (id == order_layou.getId()) {
            if (receiverFragment == null) {
                receiverFragment = new ReceiverFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content_frame, receiverFragment).commit();
            //可以封装成一个方法
            AnimationUtils.close_menu(menu_layout);
            AnimationUtils.ratationMenuIcon2(menu_icon, 500);
            status_menu = STATUS_MENU_CLOSE;


        } else if (id == sell_layout.getId()) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_content_frame, new WarmingFragment()).commit();
            AnimationUtils.close_menu(menu_layout);
            AnimationUtils.ratationMenuIcon2(menu_icon, 500);
            status_menu = STATUS_MENU_CLOSE;


        } else if (id == user_layout.getId()) {

        } else if (id == filter_img.getId()) {
            if (drawer_status_menu == DRAWER_STATUS_MENU_CLOSE) {
                AnimationUtils.ratationMenuIcon(filter_img, 250);
                drawerLayout.openDrawer(Gravity.RIGHT);
                drawer_status_menu = DRAWER_STATUS_MENU_OPEN;
            } else {
                AnimationUtils.ratationMenuIcon2(filter_img, 250);
                drawerLayout.closeDrawer(Gravity.RIGHT);
                drawer_status_menu = DRAWER_STATUS_MENU_CLOSE;
            }
        }
    }

    private void initFragment() {
        receiverFragment = new ReceiverFragment();
        senderFragment = new SenderFragment();
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(receiverFragment);
        fragmentList.add(senderFragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_frame, receiverFragment).commit();
        //  viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        //  viewPager.setCurrentItem(0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Main", "onActivityResult");
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_frame,new StoreFragment()).commitAllowingStateLoss();
    }

    @Override
    public void setTitleSize(float size) {
        super.setTitleSize(size);
    }

    @Override
    public void setTitleTest(String title) {
        super.setTitleTest(title);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        Log.d("drawer", "open");
        drawer_status_menu = DRAWER_STATUS_MENU_OPEN;

    }

    @Override
    public void onDrawerClosed(View drawerView) {
        Log.d("drawer", "close");
        drawer_status_menu = DRAWER_STATUS_MENU_CLOSE;

    }

    @Override
    public void onDrawerStateChanged(int newState) {
        Log.d("drawer", newState + "");
        if (newState == DrawerLayout.STATE_DRAGGING) {
            if (drawer_status_menu == DRAWER_STATUS_MENU_CLOSE) {
                AnimationUtils.ratationMenuIcon(filter_img, 250);
            } else {
                AnimationUtils.ratationMenuIcon2(filter_img, 250);
            }
        }
    }


    /**
     * FragmentAdapter innerclass
     */
    private class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }


}

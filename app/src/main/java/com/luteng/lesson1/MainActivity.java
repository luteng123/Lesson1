package com.luteng.lesson1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private NavigationView menu;
    private ActionBarDrawerToggle toggle;

    private ViewPager pager;
    private List<String> stringList;
    private MyAdapter adapter;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        menu = (NavigationView) findViewById(R.id.menu);
        tab = (TabLayout) findViewById(R.id.main_tab);

        ActionBar supportActionBar = getSupportActionBar();
        //显示Home
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        //可以新建个toggle开关
        toggle = new ActionBarDrawerToggle(this, drawer,0, 0);
        //下面代码可以让toggle图片动态变化
        toggle.syncState();

        //之前写的跳转
//        menu.setOnClickListener(this);

        //由DrawerLayout控制Toggle
        drawer.setDrawerListener(toggle);

        menu.setNavigationItemSelectedListener(this);

        //初始化ViewPager
        pager = (ViewPager)findViewById(R.id.pager);
        stringList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            stringList.add(String.format("第%02d页",i));
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new MyAdapter(fragmentManager,stringList);
        pager.setAdapter(adapter);

        tab.setupWithViewPager(pager);

    }

//    @Override
//    public void onClick(View v) {
//        //关闭开始菜单的界面
//        //做到兼容使用 GravityCompat
//
//        drawer.closeDrawer(GravityCompat.START);
//        startActivity(new Intent(this,SlidingActivity.class));
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //点击菜单滑出抽屉；
        //@Toggle控制DrawerLayout，点击就退出
        if(toggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.item_1:
                Toast.makeText(this,"第一项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_4:
                //防止不兼容，采用下面的形式
//                finishAffinity();
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawer.closeDrawer(Gravity.LEFT);
        return true;
    }
    //TODO：作业1： 解决  Sliding和ViewPager滑动冲突问题

}

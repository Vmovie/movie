package com.qf.vmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qf.vmovie.adapter.Shouye_ViewPagerAdapter;
import com.qf.vmovie.fragment.Shouye_LeftFragment;
import com.qf.vmovie.fragment.Shouye_RightFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] titles = {"最新", "频道"};
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> titlesList;
    private List<Fragment> fragments;
    private Shouye_ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    private void initData() {
        titlesList = new ArrayList<>();
        fragments = new ArrayList<>();

        //设置标题
        for (int i = 0; i < titles.length; i++) {
            titlesList.add(titles[i]);
        }

        fragments.add(new Shouye_LeftFragment());
        fragments.add(new Shouye_RightFragment());

        //viewPager的适配器初始化
        mViewPagerAdapter = new Shouye_ViewPagerAdapter(getSupportFragmentManager(), titlesList, fragments);

        mViewPager.setAdapter(mViewPagerAdapter);

        //使tabLayout和viewPager相关联
        mTabLayout.setupWithViewPager(mViewPager);

        //给viewPager设置滑动监听
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, LeftMenuActivity.class);
        startActivity(intent);
    }
}

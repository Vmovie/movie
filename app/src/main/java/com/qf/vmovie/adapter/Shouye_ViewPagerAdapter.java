package com.qf.vmovie.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Shouye_ViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> titlesList;
    private List<Fragment> fragments;
    public Shouye_ViewPagerAdapter(FragmentManager fm,List<String> titlesList,List<Fragment> fragments) {
        super(fm);
        this.titlesList=titlesList;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    //使标题和viewpager页数对应
    @Override
    public CharSequence getPageTitle(int position) {
        return titlesList.get(position);
    }
}
